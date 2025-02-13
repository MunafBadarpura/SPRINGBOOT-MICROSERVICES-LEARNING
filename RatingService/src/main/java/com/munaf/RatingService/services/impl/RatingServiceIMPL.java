package com.munaf.RatingService.services.impl;

import com.munaf.RatingService.entities.Rating;
import com.munaf.RatingService.repositories.RatingRepository;
import com.munaf.RatingService.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceIMPL implements RatingService {


    @Autowired
    private RatingRepository ratingRepository;

    @Override
    public Rating createRating(Rating rating) {
        return ratingRepository.save(rating);
    }


    @Override
    public List<Rating> getAllRatings() {
        return ratingRepository.findAll();
    }

    @Override
    public List<Rating> getRatingByUserId(Long userId) {
        return ratingRepository.findByUserId(userId);
    }


    @Override
    public List<Rating> getRatingByHotelId(Long hotelId) {
        return ratingRepository.findByHotelId(hotelId);
    }

    @Override
    public String deleteRating(Long ratingId) {
        ratingRepository.deleteById(ratingId);
        return "Deleted";
    }
}

