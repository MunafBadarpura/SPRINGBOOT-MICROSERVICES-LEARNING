package com.munaf.UserService.feignclient.services;

import com.munaf.UserService.entities.reponses.RatingResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "RATING-SERVICE")
public interface RatingFeignClient {

    @GetMapping("/rating/user/{userId}")
    RatingResponse getRatingByUserId(@PathVariable Long userId);

}
