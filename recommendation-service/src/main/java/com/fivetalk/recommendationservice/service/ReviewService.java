package com.fivetalk.recommendationservice.service;

import com.fivetalk.recommendationservice.model.ReviewEntity;

import java.util.List;

public interface ReviewService {
    List<ReviewEntity> listAll(int page, int size);

    ReviewEntity listById(String id);

    List<ReviewEntity> listByUserId(String userId);

    List<ReviewEntity> listByRestaurantId(String restaurantId);

    List<ReviewEntity> listTest();

    List<ReviewEntity> listTriple(int page, int size);
}
