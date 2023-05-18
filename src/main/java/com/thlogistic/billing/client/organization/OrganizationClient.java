package com.thlogistic.billing.client.organization;

import com.thlogistic.billing.adapters.dtos.BaseResponse;
import feign.Headers;
import feign.Param;
import feign.RequestLine;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface OrganizationClient {
    @RequestLine("POST /api/v1/organization/{id}")
    @Headers({
            "Content-Type: application/json",
            "Authorization: {token}"
    })
    BaseResponse<GetOrganizationDto> getOrganization(@Param("token") String token, @Param("id") String id);
}
