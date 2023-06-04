package com.thlogistic.billing.config;

import com.thlogistic.billing.client.auth.AuthorizationClient;
import com.thlogistic.billing.client.organization.OrganizationClient;
import feign.Feign;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClientConfig {

    private static final String httpPath = "http://";
    private static final String domainUrl = System.getenv("DOMAIN_URL");
    public static final String AUTHORIZATION_BASE_URL = httpPath + domainUrl + ":8000";
    public static final String ORGANIZATION_BASE_URL = httpPath + domainUrl + ":8082";

    @Bean
    public AuthorizationClient authorizationClient() {
        return Feign.builder()
                .client(new OkHttpClient())
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .target(AuthorizationClient.class, AUTHORIZATION_BASE_URL);
    }

    @Bean
    public OrganizationClient organizationClient() {
        return Feign.builder()
                .client(new OkHttpClient())
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .target(OrganizationClient.class, ORGANIZATION_BASE_URL);
    }

}
