package com.thlogistic.billing.core.usecases;


import com.thlogistic.billing.adapters.dtos.BaseTokenRequest;
import com.thlogistic.billing.adapters.dtos.CreateBillingRequest;
import com.thlogistic.billing.adapters.dtos.CreateBillingResponse;
import com.thlogistic.billing.adapters.dtos.GetBillingResponse;

import java.util.List;

public interface GetBillingByJobIdUseCase extends BaseUseCase<BaseTokenRequest<String>, List<GetBillingResponse>> {
}
