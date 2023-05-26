package com.thlogistic.billing.adapters.controllers;

import com.thlogistic.billing.adapters.dtos.CreateBillingRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/billing")
interface BillingResource {

    @GetMapping("/statistic/organization/{organizationId}")
    ResponseEntity<Object> getStatisticByOrganization(@RequestHeader(HttpHeaders.AUTHORIZATION) String token, @PathVariable String organizationId);

    @GetMapping("/statistic/dashboard")
    ResponseEntity<Object> getStatisticForDashboard(@RequestHeader(HttpHeaders.AUTHORIZATION) String token);

    @GetMapping("/find-by-job/{jobId}")
    ResponseEntity<Object> getBillingsByJobId(@RequestHeader(HttpHeaders.AUTHORIZATION) String token, @PathVariable String jobId);

    @PostMapping
    ResponseEntity<Object> createBilling(@RequestHeader(HttpHeaders.AUTHORIZATION) String token, @Valid @RequestBody CreateBillingRequest request);
}
