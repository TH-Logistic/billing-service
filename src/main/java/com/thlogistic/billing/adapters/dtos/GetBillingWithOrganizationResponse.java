package com.thlogistic.billing.adapters.dtos;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetBillingWithOrganizationResponse {
    String id;
    String organization;
    String title;
    String description;
    Double cost;
    Long createdAt;
    Integer status;
    Integer type;
}
