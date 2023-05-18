package com.thlogistic.billing.core.usecases;

public interface BaseUseCase<Request, Response> {
    Response execute(Request request);
}
