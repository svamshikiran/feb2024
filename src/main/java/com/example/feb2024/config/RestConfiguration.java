package com.example.feb2024.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestConfiguration {

    @Bean //Method level bean creation
    public RestTemplate getRestTemplate()
    {
        RestTemplateBuilder builder = new RestTemplateBuilder();
        builder.setReadTimeout(java.time.Duration.ofMinutes(1));
        builder.setConnectTimeout(java.time.Duration.ofMinutes(1));
        RestTemplate template = builder.build();
        return template;
    }
}
