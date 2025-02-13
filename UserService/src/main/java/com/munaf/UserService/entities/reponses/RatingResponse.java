package com.munaf.UserService.entities.reponses;

import com.munaf.UserService.entities.Rating;
import lombok.Data;

import java.util.List;

@Data
public class RatingResponse {

    private List<Rating> data;

}
