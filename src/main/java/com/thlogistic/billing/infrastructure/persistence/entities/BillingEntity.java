package com.thlogistic.billing.infrastructure.persistence.entities;


import com.thlogistic.billing.core.entities.Billing;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;

@Entity(name = "billing")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BillingEntity {
    @Id
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
    @Column(length = 36, nullable = false, updatable = false)
    String billingId;

    String jobId;
    String organizationId;
    String title;
    String description;
    Double cost;
    String createdAt;
    Integer status;
    Integer type;
    Boolean isRequestedByDriver;

    public Billing toBilling() {
        return new Billing(
                billingId,
                jobId,
                organizationId,
                title,
                description,
                cost,
                createdAt,
                status,
                type,
                isRequestedByDriver
        );
    }
}
