package com.thlogistic.billing.core.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Billing {
    String billingId;
    String jobId;
    String organizationId;
    String title;
    String description;
    Double cost;
    String createdAt;
    Integer status;
    Integer type;
}
