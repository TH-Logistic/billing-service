package com.thlogistic.billing.adapters.controllers;

import com.thlogistic.billing.adapters.dtos.*;
import com.thlogistic.billing.core.usecases.CreateBillingUseCase;
import com.thlogistic.billing.core.usecases.GetBillingByJobIdUseCase;
import com.thlogistic.billing.core.usecases.GetStatisticByOrganizationUseCase;
import com.thlogistic.billing.core.usecases.GetStatisticForDashboardUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BillingController extends BaseController implements BillingResource {

    private final CreateBillingUseCase createBillingUseCase;
    private final GetBillingByJobIdUseCase getBillingByJobIdUseCase;
    private final GetStatisticByOrganizationUseCase getStatisticByOrganizationUseCase;
    private final GetStatisticForDashboardUseCase getStatisticForDashboardUseCase;

    @Override
    public ResponseEntity<Object> getStatisticByOrganization(String token, String organizationId) {
        GetBillingStatisticResponse result = getStatisticByOrganizationUseCase.execute(
                new BaseTokenRequest<>(
                        token,
                        organizationId
                )
        );
        return successResponse(result, null);
    }

    @Override
    public ResponseEntity<Object> getStatisticForDashboard(String token) {
        GetBillingStatisticResponse result = getStatisticForDashboardUseCase.execute();
        return successResponse(result, null);
    }

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