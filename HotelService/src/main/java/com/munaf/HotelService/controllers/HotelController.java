package com.munaf.HotelService.controllers;

import com.munaf.HotelService.enitites.Hotel;
import com.munaf.HotelService.services.HotelService;
import com.munaf.HotelService.utils.ResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hotel")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @PostMapping
    public ResponseEntity<ResponseModel> createHotel(@RequestBody Hotel hotel) {
        ResponseModel responseModel = ResponseModel
                .builder()
                .data(hotelService.createHotel(hotel))
                .statusCode(HttpStatus.CREATED)
                .status(HttpStatus.CREATED.toString())
                .build();

        return new ResponseEntity<>(responseModel, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<ResponseModel> getAllHotels() {
        ResponseModel responseModel = ResponseModel
                .builder()
                .data(hotelService.getAllHotels())
                .statusCode(HttpStatus.OK)
                .status(HttpStatus.OK.toString())
                .build();

        return new ResponseEntity<>(responseModel, HttpStatus.OK);
    }

    @GetMapping("/{hotelId}")
    public ResponseEntity<ResponseModel> getHotelById(@PathVariable Long hotelId) {
        ResponseModel responseModel = ResponseModel
                .builder()
                .data(hotelService.getHotelById(hotelId))
                .statusCode(HttpStatus.OK)
                .status(HttpStatus.OK.toString())
                .build();

        return new ResponseEntity<>(responseModel, HttpStatus.OK);
    }

    @DeleteMapping("/{hotelId}")
    public ResponseEntity<ResponseModel> deleteHotel(@PathVariable Long hotelId) {
        ResponseModel responseModel = ResponseModel
                .builder()
                .data(hotelService.deleteHotel(hotelId))
                .statusCode(HttpStatus.OK)
                .status(HttpStatus.OK.toString())
                .build();

        return new ResponseEntity<>(responseModel, HttpStatus.OK);
    }
}

