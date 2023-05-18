package com.thlogistic.billing.adapters.controllers;

import com.thlogistic.billing.adapters.dtos.BaseTokenRequest;
import com.thlogistic.billing.adapters.dtos.CreateBillingRequest;
import com.thlogistic.billing.adapters.dtos.CreateBillingResponse;
import com.thlogistic.billing.adapters.dtos.GetBillingResponse;
import com.thlogistic.billing.core.usecases.CreateBillingUseCase;
import com.thlogistic.billing.core.usecases.GetBillingByJobIdUseCase;
import com.thlogistic.billing.core.usecases.GetBillingByOrganizationIdUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BillingController extends BaseController implements BillingResource {

    private final CreateBillingUseCase createBillingUseCase;
    private final GetBillingByJobIdUseCase getBillingByJobIdUseCase;
    private final GetBillingByOrganizationIdUseCase getBillingByOrganizationIdUseCase;

    @Override
    public ResponseEntity<Object> getBillingsByJobId(String token, String jobId) {
        List<GetBillingResponse> result = getBillingByJobIdUseCase.execute(
                new BaseTokenRequest<>(
                        token,
                        jobId
                )
        );
        return successResponse(result, null);
    }

    @Override
    public ResponseEntity<Object> getBillingsByOrganizationId(String token, String organizationId) {
        List<GetBillingResponse> result = getBillingByOrganizationIdUseCase.execute(
                new BaseTokenRequest<>(
                        token,
                        organizationId
                )
        );
        return successResponse(result, null);
    }

    @Override
    public ResponseEntity<Object> createBilling(String token, CreateBillingRequest request) {
        CreateBillingResponse result = createBillingUseCase.execute(
                new BaseTokenRequest<>(
                        token,
                        request
                )
        );
        return successResponse(result, null);
    }
}