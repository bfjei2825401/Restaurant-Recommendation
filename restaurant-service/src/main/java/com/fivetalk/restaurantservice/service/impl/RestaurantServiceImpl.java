package com.fivetalk.restaurantservice.service.impl;

import com.fivetalk.restaurantservice.mapper.RestaurantMapper;
import com.fivetalk.restaurantservice.model.RestaurantEntity;
import com.fivetalk.restaurantservice.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RestaurantServiceImpl implements RestaurantService {
    @Autowired
    private RestaurantMapper restaurantMapper;
    @Override
    public List<RestaurantEntity> getSomeRestaurants(int page, int size) {
        int limit = (page - 1) * size;
        return restaurantMapper.getSomeRestaurants(limit, size);
    }

    @Override
    public RestaurantEntity findRestaurantById(String id) {
        return restaurantMapper.getRestaurantById(id);
    }

}
