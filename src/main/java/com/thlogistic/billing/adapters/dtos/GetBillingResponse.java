package com.thlogistic.billing.adapters.dtos;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetBillingResponse {
    String id;
    String title;
    String description;
    Double cost;
    String createdAt;
    Integer status;
    Integer type;
}
