package com.fivetalk.restaurantservice.service;

import com.fivetalk.restaurantservice.model.RestaurantEntity;

import java.util.List;

public interface RestaurantService {
    List<RestaurantEntity> getSomeRestaurants(int page, int size);

    RestaurantEntity findRestaurantById(String id);

}
