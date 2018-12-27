package com.fivetalk.recommendationservice.controller;

import com.fivetalk.recommendationservice.mapper.ReviewMapper;
import com.fivetalk.recommendationservice.model.ReviewEntity;
import com.fivetalk.recommendationservice.service.ReviewService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/recommendation")
public class RecommendationController {

    @Autowired
    private ReviewService reviewService;

    private static Gson gson = new Gson();

    @RequestMapping(value = "/getRecommendationRestaurants", method = RequestMethod.GET)
    public String getRecommendationRestaurants(@RequestParam(value = "user_id", required = true) String userId) {
        return "";
    }

}
