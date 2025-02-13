package com.munaf.UserService.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class RestConfig {


    @Bean
    @Qualifier("ratingRestClient")
    @LoadBalanced
    public RestClient ratingRestClient() {
        return RestClient
                .builder()
                .baseUrl("http://localhost:8083")
                .build();
    }


    @Bean
    @Qualifier("hotelRestClient")
    @LoadBalanced
    public RestClient hotelRestClient() {
        return RestClient
                .builder()
                .baseUrl("http://localhost:8082")
                .build();
    }

}
