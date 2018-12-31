package com.fivetalk.recommendationservice.service.impl;

import com.fivetalk.recommendationservice.service.RecommendationService;
import com.fivetalk.recommendationservice.spark.SparkALS;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RecommendationServiceImpl implements RecommendationService {

    private SparkALS sparkALS = new SparkALS();
    @Override
    public List<String> getRecommendationRestaurantIdByUserIndex(int userIndex, int restaurantNum) {
        return this.sparkALS.getRecommendationByUserId(userIndex, restaurantNum);
    }
}
