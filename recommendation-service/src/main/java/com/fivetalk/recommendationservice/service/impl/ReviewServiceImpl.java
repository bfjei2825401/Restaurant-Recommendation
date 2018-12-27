package com.fivetalk.recommendationservice.service.impl;

import com.fivetalk.recommendationservice.mapper.ReviewMapper;
import com.fivetalk.recommendationservice.model.ReviewEntity;
import com.fivetalk.recommendationservice.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//@Service("ReviewService")
@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewMapper reviewMapper;


    @Override
    public List<ReviewEntity> listAll(int page, int size) {
        int limit = size * (page - 1);
        return reviewMapper.getSomeReviews(limit, size);
    }

    @Override
    public ReviewEntity listById(String id) {
        return reviewMapper.getReviewById(id);
    }

    @Override
    public List<ReviewEntity> listByUserId(String userId) {
        return reviewMapper.getReviewsByUserId(userId);
    }

    @Override
    public List<ReviewEntity> listByRestaurantId(String restaurantId) {
        return reviewMapper.getReviewsByRestaurantId(restaurantId);
    }

    @Override
    public List<ReviewEntity> listTest() {
        return reviewMapper.getReviewTest();
    }

    @Override
    public List<ReviewEntity> listTriple(int page, int size) {
        int limit = size * (page - 1);
        return reviewMapper.getSomeTripleReviews(limit, size);
    }

}
