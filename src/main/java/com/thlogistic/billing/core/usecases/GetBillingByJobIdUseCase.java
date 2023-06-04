package com.thlogistic.billing.core.usecases;


import com.thlogistic.billing.adapters.dtos.BaseTokenRequest;
import com.thlogistic.billing.adapters.dtos.GetBillingWithOrganizationResponse;

import java.util.List;

public interface GetBillingByJobIdUseCase extends BaseUseCase<BaseTokenRequest<String>, List<GetBillingWithOrganizationResponse>> {
}
