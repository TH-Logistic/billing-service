package com.thlogistic.billing.aop.exception;

public class InvalidBillingStatusException extends RuntimeException {
    public InvalidBillingStatusException(String message) {
        super(message);
    }
}
