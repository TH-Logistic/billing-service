package com.thlogistic.billing.core.usecases;


import com.thlogistic.billing.adapters.dtos.BaseTokenRequest;
import com.thlogistic.billing.adapters.dtos.GetBillingResponse;
import com.thlogistic.billing.adapters.dtos.GetBillingStatisticResponse;

import java.util.List;

public interface GetStatisticByOrganizationUseCase extends BaseUseCase<BaseTokenRequest<String>, GetBillingStatisticResponse> {
}
