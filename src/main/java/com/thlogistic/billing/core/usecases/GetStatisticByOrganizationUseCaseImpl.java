package com.thlogistic.billing.core.usecases;

import com.thlogistic.billing.adapters.dtos.BaseTokenRequest;
import com.thlogistic.billing.adapters.dtos.BillingStatisticOverviewDto;
import com.thlogistic.billing.adapters.dtos.GetBillingResponse;
import com.thlogistic.billing.adapters.dtos.GetBillingStatisticResponse;
import com.thlogistic.billing.core.entities.BillingType;
import com.thlogistic.billing.core.ports.BillingRepository;
import com.thlogistic.billing.infrastructure.persistence.entities.BillingEntity;
import com.thlogistic.billing.mapper.BillingMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GetStatisticByOrganizationUseCaseImpl implements GetStatisticByOrganizationUseCase {

    private final BillingRepository repository;

    @Override
    public GetBillingStatisticResponse execute(BaseTokenRequest<String> request) {
        BillingStatisticOverviewDto profit = new BillingStatisticOverviewDto(0.0, 0);
        BillingStatisticOverviewDto debt = new BillingStatisticOverviewDto(0.0, 0);
        List<GetBillingResponse> billingResponses = new LinkedList<>();

        List<BillingEntity> entityList = repository.findByOrganizationId(request.getRequestContent());

        for (BillingEntity entity: entityList) {

            if (BillingType.fromInt(entity.getType()) == BillingType.PROFIT) {
                profit.setAmount(profit.getAmount() + entity.getCost());
                profit.setTotalOrders(profit.getTotalOrders() + 1);
            } else if (BillingType.fromInt(entity.getType()) == BillingType.DEBT) {
                debt.setAmount(debt.getAmount() + entity.getCost());
                debt.setTotalOrders(debt.getTotalOrders() + 1);
            }

            billingResponses.add(BillingMapper.fromBillingToResponse(entity.toBilling()));
        }

        return new GetBillingStatisticResponse(
                profit,
                debt,
                billingResponses
        );
    }
}
