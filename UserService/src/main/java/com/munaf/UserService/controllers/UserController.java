package com.munaf.UserService.controllers;

import com.munaf.UserService.entities.User;
import com.munaf.UserService.services.UserService;
import com.munaf.UserService.utils.ResponseModel;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<ResponseModel> createUser(@RequestBody User user) {
        ResponseModel responseModel = ResponseModel
                .builder()
                .data(userService.createUser(user))
                .statusCode(HttpStatus.CREATED)
                .status(HttpStatus.CREATED.toString())
                .build();

        return new ResponseEntity<>(responseModel, HttpStatus.CREATED);
    }

    // FALLBACK METHOD FOR RATE-LIMITING: getAllUser
    public ResponseEntity<ResponseModel> ratingHotelLimiterFallback(Long userId, Exception ex) {
        ResponseModel responseModel = ResponseModel
                .builder()
                .data("SO MUCH REQUESTS, TRY AFTER SOME TIME")
                .statusCode(HttpStatus.INTERNAL_SERVER_ERROR)
                .status(HttpStatus.INTERNAL_SERVER_ERROR.toString())
                .build();

        return new ResponseEntity<>(responseModel, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @GetMapping
    @RateLimiter(name = "ratingHotelLimiter", fallbackMethod = "ratingHotelLimiterFallback")
    public ResponseEntity<ResponseModel> getAllUsers() {
        ResponseModel responseModel = ResponseModel
                .builder()
                .data(userService.getAllUsers())
                .statusCode(HttpStatus.OK)
                .status(HttpStatus.OK.toString())
                .build();

        return new ResponseEntity<>(responseModel, HttpStatus.OK);
    }

    // FALLBACK METHOD FOR CircuitBreaker: getUserById
    public ResponseEntity<ResponseModel> ratingHotelFallback(Long userId, Exception ex) {
        ResponseModel responseModel = ResponseModel
                .builder()
                .data("FALLBACK GENERATED ON RATING-HOTEL-SERVICE")
                .statusCode(HttpStatus.INTERNAL_SERVER_ERROR)
                .status(HttpStatus.INTERNAL_SERVER_ERROR.toString())
                .build();

        return new ResponseEntity<>(responseModel, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/{userId}")
    @CircuitBreaker(name = "ratingHotelBreaker", fallbackMethod = "ratingHotelFallback")
    public ResponseEntity<ResponseModel> getUserById(@PathVariable Long userId) {
        ResponseModel responseModel = ResponseModel
                .builder()
                .data(userService.getUserById(userId))
                .statusCode(HttpStatus.OK)
                .status(HttpStatus.OK.toString())
                .build();

        return new ResponseEntity<>(responseModel, HttpStatus.OK);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<ResponseModel> deleteUser(@PathVariable Long userId) {
        ResponseModel responseModel = ResponseModel
                .builder()
                .data(userService.deleteUser(userId))
                .statusCode(HttpStatus.OK)
                .status(HttpStatus.OK.toString())
                .build();

        return new ResponseEntity<>(responseModel, HttpStatus.OK);
    }

}
