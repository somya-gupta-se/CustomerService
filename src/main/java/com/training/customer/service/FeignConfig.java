package com.training.customer.service;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import java.util.Collections;

@Configuration
public class FeignConfig {
    @Bean
    public HttpMessageConverters customConverters() {
        return new HttpMessageConverters(Collections.emptyList());
    }
}