package com.thlogistic.billing.core.usecases;

import com.thlogistic.billing.adapters.dtos.*;
import com.thlogistic.billing.client.organization.GetOrganizationResponse;
import com.thlogistic.billing.client.organization.OrganizationClient;
import com.thlogistic.billing.core.ports.BillingRepository;
import com.thlogistic.billing.infrastructure.persistence.entities.BillingEntity;
import com.thlogistic.billing.mapper.BillingMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GetBillingByJobIdUseCaseImpl implements GetBillingByJobIdUseCase {

    private final BillingRepository repository;
    private final OrganizationClient organizationClient;

    @Override
    public List<GetBillingWithOrganizationResponse> execute(BaseTokenRequest<String> baseTokenRequest) {
        String token = baseTokenRequest.getToken();
        String jobId = baseTokenRequest.getRequestContent();
        List<GetBillingWithOrganizationResponse> response = new LinkedList<>();

        List<BillingEntity> entityList = repository.findByJobId(jobId);

        entityList.forEach(e -> {
            GetOrganizationResponse organizationResponse = organizationClient.getOrganization(token, e.getOrganizationId()).getData();
            response.add(BillingMapper.fromBillingToResponseWithOrganization(e.toBilling(), organizationResponse.getName()));
        });

        return response;
    }
}
