package com.thlogistic.billing.mapper;


import com.thlogistic.billing.adapters.dtos.GetBillingResponse;
import com.thlogistic.billing.core.entities.Billing;

public class BillingMapper {
    public static GetBillingResponse fromBillingToResponse(Billing billing) {
        GetBillingResponse response = new GetBillingResponse();
        response.setId(billing.getBillingId());
        response.setTitle(billing.getTitle());
        response.setDescription(billing.getDescription());
        response.setCost(billing.getCost());
        response.setCreatedAt(billing.getCreatedAt());
        response.setStatus(billing.getStatus());
        response.setType(billing.getType());
        return response;
    }
}
