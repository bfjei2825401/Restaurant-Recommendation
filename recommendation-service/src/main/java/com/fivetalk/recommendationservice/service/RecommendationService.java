package com.fivetalk.recommendationservice.service;

import java.util.List;

public interface RecommendationService {
    List<String> getRecommendationRestaurantIdByUserIndex(int userIndex, int restaurantNum);
}
