package com.munaf.UserService.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rating {

    private Long ratingId;
    private Long userId;
    private Integer rating;
    private String feedback;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) // Ignore during serialization but allow during deserialization
    private Long hotelId;

    private Hotel hotel;
}
