package com.munaf.HotelService.controllers;

import com.munaf.HotelService.utils.ResponseModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @GetMapping
    public ResponseModel getAllEmployees() {
        List<String> employees = List.of("MUNAF", "AFNAN", "SAHAD");
        return  ResponseModel
                .builder()
                .data(employees)
                .statusCode(HttpStatus.OK)
                .status(HttpStatus.OK.toString())
                .build();
    }

}
