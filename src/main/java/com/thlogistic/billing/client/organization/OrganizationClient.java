package com.thlogistic.billing.client.organization;

import com.thlogistic.billing.adapters.dtos.BaseResponse;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

public interface OrganizationClient {
    @RequestLine("POST /api/v1/organization/{id}")
    @Headers({
            "Content-Type: application/json",
            "Authorization: {token}"
    })
    BaseResponse<GetOrganizationResponse> getOrganization(@Param("token") String token, @Param("id") String id);
}
