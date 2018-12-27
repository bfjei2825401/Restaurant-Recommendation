package com.fivetalk.recommendationservice.mapper;

import com.fivetalk.recommendationservice.model.ReviewEntity;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewMapper {

    @Select("SELECT id,stars,date,text,useful,funny,cool,business_id,user_id FROM review LIMIT #{limit},#{offset}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "stars", column = "stars"),
            @Result(property = "date", column = "date"),
            @Result(property = "text", column = "text"),
            @Result(property = "useful", column = "useful"),
            @Result(property = "funny", column = "funny"),
            @Result(property = "cool", column = "cool"),
            @Result(property = "businessId", column = "business_id"),
            @Result(property = "userId", column = "user_id")
    })
    public List<ReviewEntity> getSomeReviews(int limit, int offset);

    @Select("SELECT id,stars,date,text,useful,funny,cool,business_id,user_id FROM review WHERE id=#{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "stars", column = "stars"),
            @Result(property = "date", column = "date"),
            @Result(property = "text", column = "text"),
            @Result(property = "useful", column = "useful"),
            @Result(property = "funny", column = "funny"),
            @Result(property = "cool", column = "cool"),
            @Result(property = "businessId", column = "business_id"),
            @Result(property = "userId", column = "user_id")
    })
    public ReviewEntity getReviewById(String id);

    @Select("SELECT id,stars,date,text,useful,funny,cool,business_id,user_id FROM review WHERE user_id=#{user_id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "stars", column = "stars"),
            @Result(property = "date", column = "date"),
            @Result(property = "text", column = "text"),
            @Result(property = "useful", column = "useful"),
            @Result(property = "funny", column = "funny"),
            @Result(property = "cool", column = "cool"),
            @Result(property = "businessId", column = "business_id"),
            @Result(property = "userId", column = "user_id")
    })
    public List<ReviewEntity> getReviewsByUserId(String user_id);

    @Select("SELECT id,stars,date,text,useful,funny,cool,business_id,user_id FROM review WHERE business_id=#{restaurantId}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "stars", column = "stars"),
            @Result(property = "date", column = "date"),
            @Result(property = "text", column = "text"),
            @Result(property = "useful", column = "useful"),
            @Result(property = "funny", column = "funny"),
            @Result(property = "cool", column = "cool"),
            @Result(property = "businessId", column = "business_id"),
            @Result(property = "userId", column = "user_id")
    })
    public List<ReviewEntity> getReviewsByRestaurantId(String restaurantId);

    @Select("SELECT id,stars,business_id,user_id FROM review")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "stars", column = "stars"),
            @Result(property = "businessId", column = "business_id"),
            @Result(property = "userId", column = "user_id")
    })
    public List<ReviewEntity> getAllReviews();

    @Select("SELECT id,stars,date,text,useful,funny,cool,business_id,user_id FROM review LIMIT 0,10")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "stars", column = "stars"),
            @Result(property = "date", column = "date"),
            @Result(property = "text", column = "text"),
            @Result(property = "useful", column = "useful"),
            @Result(property = "funny", column = "funny"),
            @Result(property = "cool", column = "cool"),
            @Result(property = "businessId", column = "business_id"),
            @Result(property = "userId", column = "user_id")
    })
    public List<ReviewEntity> getReviewTest();

    @Select("SELECT stars,business_id,user_id FROM review LIMIT #{limit},#{size}")
    @Results({
            @Result(property = "stars", column = "stars"),
            @Result(property = "businessId", column = "business_id"),
            @Result(property = "userId", column = "user_id")
    })
    public List<ReviewEntity> getSomeTripleReviews(int limit, int size);

}
