package com.thlogistic.billing.config;

import com.thlogistic.billing.client.auth.AuthorizationClient;
import feign.Feign;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    private static final String httpPath = "http://";
    private static final String domainUrl = System.getenv("DOMAIN_URL");
    public static final String AUTHORIZATION_BASE_URL = httpPath + domainUrl + ":8000";

    @Bean
    public AuthorizationClient authorizationClient() {
        return Feign.builder()
                .client(new OkHttpClient())
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .target(AuthorizationClient.class, AUTHORIZATION_BASE_URL);
    }

}
