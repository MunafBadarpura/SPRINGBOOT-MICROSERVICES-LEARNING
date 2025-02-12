package com.munaf.HotelService.advices;

import com.munaf.HotelService.exeptions.ResourceAlreadyExistsException;
import com.munaf.HotelService.exeptions.ResourceNotFoundException;
import com.munaf.HotelService.utils.ResponseModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ResponseModel> handleResourceNotFoundException(ResourceNotFoundException ex) {
        ResponseModel responseModel = ResponseModel.builder()
                .data(ex.getLocalizedMessage())
                .statusCode(HttpStatus.BAD_REQUEST)
                .status(HttpStatus.BAD_REQUEST.toString())
                .build();

        return new ResponseEntity<>(responseModel, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(ResourceAlreadyExistsException.class)
    public ResponseEntity<ResponseModel> handleResourceAlreadyExistsException(ResourceAlreadyExistsException ex) {
        ResponseModel responseModel = ResponseModel.builder()
                .data(ex.getLocalizedMessage())
                .statusCode(HttpStatus.BAD_REQUEST)
                .status(HttpStatus.BAD_REQUEST.toString())
                .build();

        return new ResponseEntity<>(responseModel, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseModel> handleException(Exception ex) {
        ResponseModel responseModel = ResponseModel.builder()
                .data(ex.getLocalizedMessage())
                .statusCode(HttpStatus.INTERNAL_SERVER_ERROR)
                .status(HttpStatus.INTERNAL_SERVER_ERROR.toString())
                .build();

        return new ResponseEntity<>(responseModel, HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
