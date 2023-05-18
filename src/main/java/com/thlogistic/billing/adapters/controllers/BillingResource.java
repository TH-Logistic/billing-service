package com.thlogistic.billing.adapters.controllers;

import com.thlogistic.billing.adapters.dtos.CreateBillingRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/billing")
interface BillingResource {

    @GetMapping("/find-by-job/{jobId}")
    ResponseEntity<Object> getBillingsByJobId(@RequestHeader(HttpHeaders.AUTHORIZATION) String token, @PathVariable String jobId);

    @GetMapping("/find-by-organization/{organizationId}")
    ResponseEntity<Object> getBillingsByOrganizationId(@RequestHeader(HttpHeaders.AUTHORIZATION) String token, @PathVariable String organizationId);

    @PostMapping
    ResponseEntity<Object> createBilling(@RequestHeader(HttpHeaders.AUTHORIZATION) String token, @Valid @RequestBody CreateBillingRequest request);
}
