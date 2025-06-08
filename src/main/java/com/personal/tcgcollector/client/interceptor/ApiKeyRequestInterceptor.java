package com.personal.tcgcollector.client.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ApiKeyRequestInterceptor implements RequestInterceptor {

    @Value("${apitcg.api-key}")
    private String apiKey;

    @PostConstruct
    public void debugKey() {
        System.out.println(" Loaded API Key: " + apiKey);
    }

    @Override
    public void apply(RequestTemplate template) {
        System.out.println(" Adding API key header: " + apiKey);
        template.header("x-api-key", apiKey);

        System.out.println("---- Headers After ----");
        template.headers().forEach((k, v) -> System.out.println(k + ": " + v));
    }
}
