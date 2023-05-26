package com.thlogistic.billing.adapters.repositories;

import com.thlogistic.billing.infrastructure.persistence.entities.BillingEntity;
import com.thlogistic.billing.core.ports.BillingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class BillingRepositoryImpl implements BillingRepository {
    private final PostgresBillingRepository repository;

    @Override
    public String insert(BillingEntity billing) {
        return repository.save(billing).getBillingId();
    }

    @Override
    public String save(BillingEntity billing) {
        return repository.save(billing).getBillingId();
    }

    @Override
    public Optional<BillingEntity> findById(String id) {
        return repository.findById(id);
    }

    @Override
    public List<BillingEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public List<BillingEntity> findByJobId(String jobId) {
        return repository.findAllByJobId(jobId);
    }

    @Override
    public List<BillingEntity> findByOrganizationId(String organizationId) {
        return repository.findAllByOrganizationId(organizationId);
    }
}
