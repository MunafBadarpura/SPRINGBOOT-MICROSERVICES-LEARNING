package com.munaf.RatingService.repositories;

import com.munaf.RatingService.entities.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends MongoRepository<Rating, Long> {


    List<Rating> findByUserId(Long userId);

    List<Rating> findByHotelId(Long hotelId);
}
