package com.thlogistic.billing.core.usecases;


import com.thlogistic.billing.adapters.dtos.BaseTokenRequest;
import com.thlogistic.billing.adapters.dtos.CreateBillingRequest;
import com.thlogistic.billing.adapters.dtos.CreateBillingResponse;

public interface CreateBillingUseCase extends BaseUseCase<BaseTokenRequest<CreateBillingRequest>, CreateBillingResponse> {
}
