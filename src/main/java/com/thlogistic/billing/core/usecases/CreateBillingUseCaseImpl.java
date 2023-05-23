package com.thlogistic.billing.core.usecases;

import com.thlogistic.billing.adapters.dtos.BaseTokenRequest;
import com.thlogistic.billing.adapters.dtos.CreateBillingRequest;
import com.thlogistic.billing.adapters.dtos.CreateBillingResponse;
import com.thlogistic.billing.core.entities.BillingStatus;
import com.thlogistic.billing.core.entities.BillingType;
import com.thlogistic.billing.core.ports.BillingRepository;
import com.thlogistic.billing.infrastructure.persistence.entities.BillingEntity;
import com.thlogistic.billing.utils.DateTimeHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateBillingUseCaseImpl implements CreateBillingUseCase {

    private final BillingRepository repository;

    @Override
    public CreateBillingResponse execute(BaseTokenRequest<CreateBillingRequest> baseTokenRequest) {
        String token = baseTokenRequest.getToken();
        CreateBillingRequest requestContent = baseTokenRequest.getRequestContent();

        BillingStatus.fromInt(requestContent.getStatus());
        BillingType.fromInt(requestContent.getType());

        BillingEntity.BillingEntityBuilder entityBuilder = BillingEntity.builder();
        entityBuilder.jobId(requestContent.getJobId());
        entityBuilder.organizationId(requestContent.getOrganizationId());
        entityBuilder.title(requestContent.getTitle());
        entityBuilder.description(requestContent.getDescription());
        entityBuilder.cost(requestContent.getCost());
        entityBuilder.createdAt(DateTimeHelper.getCurrentTimeFormatted());
        entityBuilder.status(requestContent.getStatus());
        entityBuilder.type(requestContent.getType());

        String id = repository.insert(entityBuilder.build());

        return new CreateBillingResponse(id);
    }
}
