package com.thlogistic.billing.aop.exception;

public class InvalidBillingTypeException extends RuntimeException {
    public InvalidBillingTypeException(String message) {
        super(message);
    }
}
