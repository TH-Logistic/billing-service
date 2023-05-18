package com.thlogistic.billing.core.entities;


import com.thlogistic.billing.aop.exception.InvalidBillingTypeException;

public enum BillingType {
    DEBT(1),
    PROFIT(2);

    public final Integer typeCode;

    BillingType(Integer code) {
        typeCode = code;
    }

    public static BillingType fromInt(Integer value) {
        for (BillingType type : values()) {
            if (type.typeCode.equals(value)) {
                return type;
            }
        }
        throw new InvalidBillingTypeException("Billing type not found");
    }

}
