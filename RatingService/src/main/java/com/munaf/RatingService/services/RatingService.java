package com.munaf.RatingService.services;

import com.munaf.RatingService.entities.Rating;

import java.util.List;

public interface RatingService {

    public Rating createRating(Rating rating);

    public List<Rating> getRatingByUserId(Long userId);

    public List<Rating> getRatingByHotelId(Long hotelId);

    public List<Rating> getAllRatings();

    public String deleteRating(Long ratingId);

}
