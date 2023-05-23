package com.thlogistic.billing.adapters.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateBillingRequest {
    @NotEmpty(message = "Invalid job ID")
    String jobId;
    @NotEmpty(message = "Invalid organization ID")
    String organizationId;
    @NotEmpty(message = "Invalid title")
    String title;
    @NotEmpty(message = "Invalid description")
    String description;
    @NotEmpty(message = "Invalid cost")
    @Min(value = 0, message = "Invalid cost")
    Double cost;
    @NotEmpty(message = "Invalid status")
    Integer status;
    @NotEmpty(message = "Invalid type")
    Integer type;
}
