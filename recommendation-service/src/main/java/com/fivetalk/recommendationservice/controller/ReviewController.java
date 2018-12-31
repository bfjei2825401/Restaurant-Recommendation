package com.fivetalk.recommendationservice.controller;

import com.fivetalk.recommendationservice.model.ReviewEntity;
import com.fivetalk.recommendationservice.service.ReviewService;
import com.fivetalk.recommendationservice.util.ResponseMsg;
import com.fivetalk.recommendationservice.util.ResponseUtil;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/review")
public class ReviewController {
    private Gson gson = new Gson();
    @Autowired
    private ReviewService reviewService;

    @RequestMapping(value = "/getReviews", method = RequestMethod.GET)
    public String listReviews(@RequestParam(value = "page", defaultValue = "1") int page,
                              @RequestParam(value = "size", defaultValue = "10") int size) {
        List<ReviewEntity> reviewEntityList = reviewService.listAll(page, size);
        ResponseMsg responseMsg = checkReviewEntityList(reviewEntityList);
        return gson.toJson(responseMsg);
    }

    @RequestMapping(value = "/getReviewById", method = RequestMethod.GET)
    public String listReviewById(@RequestParam(value = "review_id") String reviewId) {
        ResponseMsg responseMsg = checkReviewEntity(reviewService.listById(reviewId));
        return gson.toJson(responseMsg);
    }

    @RequestMapping(value = "/getReviewByUserId", method = RequestMethod.GET)
    public String listReviewByUserId(@RequestParam(value = "user_id") String userId) {
        ResponseMsg responseMsg = checkReviewEntityList(reviewService.listByUserId(userId));
        return gson.toJson(responseMsg);
    }

    @RequestMapping(value = "/getReviewByRestaurantId", method = RequestMethod.GET)
    public String listReviewByRestaurantId(@RequestParam(value = "restaurant_id") String restaurantId) {
        ResponseMsg responseMsg = checkReviewEntityList(reviewService.listByRestaurantId(restaurantId));
        return gson.toJson(responseMsg);
    }

//    @RequestMapping(value = "/getReviewTest", method = RequestMethod.GET)
//    public String listReviewTest() {
//        List<ReviewEntity> list = reviewService.listTest();
//        return gson.toJson(list);
//    }

    private ResponseMsg checkReviewEntity(ReviewEntity reviewEntity) {
        ResponseMsg responseMsg;
        if (reviewEntity == null) {
            responseMsg = ResponseUtil.error(500, "failed", "");
        } else {
            responseMsg = ResponseUtil.success(reviewEntity);
        }
        return responseMsg;
    }

    private ResponseMsg checkReviewEntityList(List<ReviewEntity> list) {
        ResponseMsg responseMsg;
        if (list.size() < 1) {
            responseMsg = ResponseUtil.error(500, "failed", "");
        }else {
            responseMsg = ResponseUtil.success(list);
        }
        return responseMsg;
    }
}
