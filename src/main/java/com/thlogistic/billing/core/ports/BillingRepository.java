package com.thlogistic.billing.core.ports;



import com.thlogistic.billing.infrastructure.persistence.entities.BillingEntity;

import java.util.List;
import java.util.Optional;

public interface BillingRepository {
    String insert(BillingEntity job);

    String save(BillingEntity job);

    Optional<BillingEntity> findById(String id);
    List<BillingEntity> findAll();
    List<BillingEntity> findByJobId(String jobId);
    List<BillingEntity> findByOrganizationId(String organizationId);
}
