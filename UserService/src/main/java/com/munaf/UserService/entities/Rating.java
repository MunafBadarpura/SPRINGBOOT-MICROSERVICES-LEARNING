package com.munaf.UserService.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rating {

    private Long ratingId;
    private Long userId;
    private Long hotelId;
    private Integer rating;
    private String feedback;

}
