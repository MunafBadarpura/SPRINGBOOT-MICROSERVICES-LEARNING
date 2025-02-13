package com.munaf.UserService.services.impl;

import com.munaf.UserService.entities.Hotel;
import com.munaf.UserService.entities.Rating;
import com.munaf.UserService.entities.reponses.HotelResponse;
import com.munaf.UserService.entities.reponses.RatingResponse;
import com.munaf.UserService.entities.User;
import com.munaf.UserService.exceptions.ResourceAlreadyExistsException;
import com.munaf.UserService.exceptions.ResourceNotFoundException;
import com.munaf.UserService.repositories.UserRepository;
import com.munaf.UserService.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
@Slf4j
public class UserServiceIMPL implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    @Qualifier("ratingRestClient")
    private RestClient ratingRestClient;

    @Autowired
    @Qualifier("hotelRestClient")
    private RestClient hotelRestClient;

    public List<Rating> getRatingsForUser(Long userId) {
        RatingResponse ratingResponses = ratingRestClient.get()
                .uri("rating/user/{userId}", userId)// http://localhost:8083/rating/user/{userId}
                .retrieve()
                .body(RatingResponse.class);

        return ratingResponses.getData();
    }

    public Hotel getHotelByHotelId(Long hotelId) {
        HotelResponse hotelResponse = hotelRestClient.get()
                .uri("/hotel/{hotelId}", hotelId)// http://localhost:8082/hotel/{hotelId}
                .retrieve()
                .body(HotelResponse.class);

        return hotelResponse.getData();
    }


    @Override
    public User createUser(User user) {
        if (userRepository.existsByEmail(user.getEmail())) throw new ResourceAlreadyExistsException("Email Already Exists");
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long userId) {
        User user =  userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User Not Found With Id" + userId));

        // Setting Ratings
        user.setRatings(getRatingsForUser(userId));

        // Setting Hotel Inside Ratings
        user.getRatings().forEach(rating -> rating.setHotel(getHotelByHotelId(rating.getHotelId())));

        return user;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = userRepository.findAll();

        // Setting Ratings For Each User
        users.forEach(user -> user.setRatings(getRatingsForUser(user.getId())));

        // Setting Hotel For Each Rating
        users.forEach(user -> {
            user.getRatings().forEach(rating -> rating.setHotel(getHotelByHotelId(rating.getHotelId())));
        });

        return users;
    }

    @Override
    public String deleteUser(Long userId) {
        userRepository.deleteById(userId);
        return "Deleted";
    }
}
