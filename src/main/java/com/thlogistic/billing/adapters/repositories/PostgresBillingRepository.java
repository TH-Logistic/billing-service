package com.thlogistic.billing.adapters.repositories;


import com.thlogistic.billing.infrastructure.persistence.entities.BillingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostgresBillingRepository extends JpaRepository<BillingEntity, String> {
    List<BillingEntity> findAllByJobId(String jobId);
    List<BillingEntity> findAllByOrganizationId(String organizationId);
}
