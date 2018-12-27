package com.fivetalk.restaurantservice.mapper;

import com.fivetalk.restaurantservice.model.RestaurantPhotoEntity;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantPhotoMapper {
    @Select("SELECT * FROM photo WHERE id=#{id}")
    @Results({
            @Result(property = "id",  column = "id"),
            @Result(property = "businessId", column = "business_id"),
            @Result(property = "caption", column = "caption"),
            @Result(property = "label", column = "label"),
    })
    RestaurantPhotoEntity findRestaurantPhotoById(String id);

    @Select("SELECT * FROM photo WHERE business_id=#{businessId}")
    @Results({
            @Result(property = "id",  column = "id"),
            @Result(property = "businessId", column = "business_id"),
            @Result(property = "caption", column = "caption"),
            @Result(property = "label", column = "label"),
    })
    List<RestaurantPhotoEntity> findRestaurantPhotosByBusinessId(String businessId);

    @Select("SELECT * FROM photo LIMIT #{limit},#{size}")
    @Results({
            @Result(property = "id",  column = "id"),
            @Result(property = "businessId", column = "business_id"),
            @Result(property = "caption", column = "caption"),
            @Result(property = "label", column = "label"),
    })
    List<RestaurantPhotoEntity> getSomeRestaurantPhotos(int limit, int size);
}
