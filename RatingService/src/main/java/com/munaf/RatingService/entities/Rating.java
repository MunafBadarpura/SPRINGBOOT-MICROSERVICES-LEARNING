package com.munaf.RatingService.entities;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document("rating")
public class Rating {

    private Long ratingId;
    private Long userId;
    private Long hotelId;
    private Integer rating;
    private String feedback;

}
