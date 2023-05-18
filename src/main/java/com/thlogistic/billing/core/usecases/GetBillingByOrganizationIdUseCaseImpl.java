package com.thlogistic.billing.core.usecases;

import com.thlogistic.billing.adapters.dtos.BaseTokenRequest;
import com.thlogistic.billing.adapters.dtos.GetBillingResponse;
import com.thlogistic.billing.core.ports.BillingRepository;
import com.thlogistic.billing.infrastructure.persistence.entities.BillingEntity;
import com.thlogistic.billing.mapper.BillingMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GetBillingByOrganizationIdUseCaseImpl implements GetBillingByJobIdUseCase {

    private final BillingRepository repository;

    @Override
    public List<GetBillingResponse> execute(BaseTokenRequest<String> request) {
        List<GetBillingResponse> response = new LinkedList<>();

        List<BillingEntity> entityList = repository.findByOrganizationId(request.getRequestContent());

        entityList.forEach(e -> {
            response.add(BillingMapper.fromBillingToResponse(e.toBilling()));
        });

        return response;
    }
}
