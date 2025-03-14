package com.munaf.RatingService.utils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatusCode;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseModel {

    private Object data;
    private HttpStatusCode statusCode;
    private String status;

}
