package com.fivetalk.restaurantservice.controller;

import com.fivetalk.restaurantservice.model.RestaurantEntity;
import com.fivetalk.restaurantservice.service.RestaurantService;
import com.fivetalk.restaurantservice.util.ResponseMsg;
import com.fivetalk.restaurantservice.util.ResponseUtil;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/restaurant")
public class RestaurantController {
    private static Gson gson = new Gson();
    private ResponseUtil responseUtil = new ResponseUtil();
    @Autowired
    private RestaurantService restaurantService;

    @RequestMapping(value = "/getRestaurants", method = RequestMethod.GET)
    public String getSomeRestaurant(@RequestParam(value = "page", defaultValue = "1", required = true) int page,
                                    @RequestParam(value = "size", defaultValue = "10", required = true) int size) {
        List<RestaurantEntity> restaurantEntityList = restaurantService.getSomeRestaurants(page, size);
        ResponseMsg responseMsg = responseUtil.success(restaurantEntityList);
        return gson.toJson(responseMsg);
    }

    @RequestMapping(value = "/getRestaurantsById", method = RequestMethod.GET)
    public String getRestaurantById(@RequestParam(value = "restaurant_id", required = true) String restaurant_id) {
        RestaurantEntity restaurantEntity = restaurantService.findRestaurantById(restaurant_id);
        ResponseMsg responseMsg = responseUtil.success(restaurantEntity);
        return gson.toJson(responseMsg);
    }


}
