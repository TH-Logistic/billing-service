package com.thlogistic.billing.adapters.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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
    @NotNull(message = "Invalid cost")
    @Min(value = 0, message = "Invalid cost")
    Double cost;
    @NotNull(message = "Invalid status")
    Integer status;
    @NotNull(message = "Invalid type")
    Integer type;
}
