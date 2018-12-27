package com.fivetalk.restaurantservice.mapper;

import com.fivetalk.restaurantservice.model.RestaurantEntity;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantMapper {
    @Select("SELECT * FROM business WHERE id=#{id}")
    @Results({
            @Result(property = "id",  column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "neighborhood", column = "neighborhood"),
            @Result(property = "address", column = "address"),
            @Result(property = "city", column = "city"),
            @Result(property = "state", column = "state"),
            @Result(property = "postalCode", column = "postal_code"),
            @Result(property = "latitude", column = "latitude"),
            @Result(property = "longtitude", column = "longtitude"),
            @Result(property = "stars", column = "stars"),
            @Result(property = "reviewCount", column = "review_count"),
            @Result(property = "isOpen", column = "is_open")
    })
    public RestaurantEntity getRestaurantById(String id);

    @Select("SELECT * FROM business LIMIT #{limit},#{offset}")
    @Results({
            @Result(property = "id",  column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "neighborhood", column = "neighborhood"),
            @Result(property = "address", column = "address"),
            @Result(property = "city", column = "city"),
            @Result(property = "state", column = "state"),
            @Result(property = "postalCode", column = "postal_code"),
            @Result(property = "latitude", column = "latitude"),
            @Result(property = "longtitude", column = "longtitude"),
            @Result(property = "stars", column = "stars"),
            @Result(property = "reviewCount", column = "review_count"),
            @Result(property = "isOpen", column = "is_open")
    })
    public List<RestaurantEntity> getSomeRestaurants(int limit, int offset);
}
