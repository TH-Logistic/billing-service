package com.thlogistic.billing.aop.exception;

public class DataNotFoundException extends RuntimeException {
    public DataNotFoundException(String modelName) {
        super(String.format("Cannot find %s", modelName));
    }
}
