package com.fivetalk.recommendationservice.controller;

import com.fivetalk.recommendationservice.mapper.ReviewMapper;
import com.fivetalk.recommendationservice.model.ReviewEntity;
import com.fivetalk.recommendationservice.service.RecommendationService;
import com.fivetalk.recommendationservice.service.ReviewService;
import com.fivetalk.recommendationservice.util.ResponseMsg;
import com.fivetalk.recommendationservice.util.ResponseUtil;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/recommendation")
public class RecommendationController {

    private static Gson gson = new Gson();
    @Autowired
    private RecommendationService recommendationService;
    @RequestMapping(value = "/getRecommendationRestaurants", method = RequestMethod.GET)
    public String getRecommendationRestaurants(@RequestParam(value = "userIndex", required = true) int userIndex,
                                               @RequestParam(value = "restaurantNum", required = true) int restaurantNum) {
        List<String> list = this.recommendationService.getRecommendationRestaurantIdByUserIndex(userIndex, restaurantNum);
        ResponseMsg responseMsg;
        if (list.size() < 1) {
            responseMsg = ResponseUtil.error(500, "Can not find any recommendations", list);
        }
        responseMsg = ResponseUtil.success(list);
        return gson.toJson(responseMsg);
    }

}
