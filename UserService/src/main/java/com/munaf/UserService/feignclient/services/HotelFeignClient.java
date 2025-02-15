package com.munaf.UserService.feignclient.services;

import com.munaf.UserService.entities.Hotel;
import com.munaf.UserService.entities.reponses.HotelResponse;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "HOTEL-SERVICE")
public interface HotelFeignClient {

    @GetMapping("/hotel/{hotelId}")
    HotelResponse getHotelById(@PathVariable Long hotelId);


}
