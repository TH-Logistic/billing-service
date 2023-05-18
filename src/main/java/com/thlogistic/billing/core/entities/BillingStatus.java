package com.thlogistic.billing.core.entities;


import com.thlogistic.billing.aop.exception.InvalidBillingStatusException;

public enum BillingStatus {
    PENDING(1),
    PAID(2);

    public final Integer statusCode;

    BillingStatus(Integer code) {
        statusCode = code;
    }

    public static BillingStatus fromInt(Integer value) {
        for (BillingStatus type: values()) {
            if (type.statusCode.equals(value)) {
                return type;
            }
        }
        throw new InvalidBillingStatusException("Billing status not found");
    }

}
