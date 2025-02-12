package com.munaf.RatingService.controllers;

import com.munaf.RatingService.entities.Rating;
import com.munaf.RatingService.services.RatingService;
import com.munaf.RatingService.utils.ResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rating")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @PostMapping
    public ResponseEntity<ResponseModel> createRating(@RequestBody Rating rating) {
        ResponseModel responseModel = ResponseModel
                .builder()
                .data(ratingService.createRating(rating))
                .statusCode(HttpStatus.CREATED)
                .status(HttpStatus.CREATED.toString())
                .build();

        return new ResponseEntity<>(responseModel, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<ResponseModel> getAllRatings() {
        ResponseModel responseModel = ResponseModel
                .builder()
                .data(ratingService.getAllRatings())
                .statusCode(HttpStatus.OK)
                .status(HttpStatus.OK.toString())
                .build();

        return new ResponseEntity<>(responseModel, HttpStatus.OK);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<ResponseModel> getRatingByUserId(@PathVariable Long userId) {
        ResponseModel responseModel = ResponseModel
                .builder()
                .data(ratingService.getRatingByUserId(userId))
                .statusCode(HttpStatus.OK)
                .status(HttpStatus.OK.toString())
                .build();

        return new ResponseEntity<>(responseModel, HttpStatus.OK);
    }

    @GetMapping("/hotel/{hotelId}")
    public ResponseEntity<ResponseModel> getRatingByHotelId(@PathVariable Long hotelId) {
        ResponseModel responseModel = ResponseModel
                .builder()
                .data(ratingService.getRatingByHotelId(hotelId))
                .statusCode(HttpStatus.OK)
                .status(HttpStatus.OK.toString())
                .build();

        return new ResponseEntity<>(responseModel, HttpStatus.OK);
    }

    @DeleteMapping("/{ratingId}")
    public ResponseEntity<ResponseModel> deleteRating(@PathVariable Long ratingId) {
        ResponseModel responseModel = ResponseModel
                .builder()
                .data(ratingService.deleteRating(ratingId))
                .statusCode(HttpStatus.OK)
                .status(HttpStatus.OK.toString())
                .build();

        return new ResponseEntity<>(responseModel, HttpStatus.OK);
    }
}