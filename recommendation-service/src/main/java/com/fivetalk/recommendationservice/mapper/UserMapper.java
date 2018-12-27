package com.fivetalk.recommendationservice.mapper;

import com.fivetalk.recommendationservice.model.UserEntity;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    @Select("SELECT * FROM user LIMIT #{limit},#{offset}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "reviewCount", column = "review_count"),
            @Result(property = "yelpingSince", column = "yelping_since"),
            @Result(property = "useful", column = "useful"),
            @Result(property = "funny", column = "funny"),
            @Result(property = "cool", column = "cool"),
            @Result(property = "fans", column = "fans"),
            @Result(property = "averageStars", column = "average_stars"),
            @Result(property = "complimentHot", column = "compliment_hot"),
            @Result(property = "complimentMore", column = "compliment_more"),
            @Result(property = "complimentProfile", column = "compliment_profile"),
            @Result(property = "complimentCute", column = "compliment_cute"),
            @Result(property = "complimentList", column = "compliment_list"),
            @Result(property = "complimentNote", column = "compliment_note"),
            @Result(property = "complimentPlain", column = "compliment_plain"),
            @Result(property = "complimentCool", column = "compliment_cool"),
            @Result(property = "complimentFunny", column = "compliment_funny"),
            @Result(property = "complimentWriter", column = "compliment_writer"),
            @Result(property = "complimentPhotos", column = "compliment_photos")
    })
    public List<UserEntity> getSomeUsers(int limit, int offset);

    @Select("SELECT * FROM user WHERE id=#{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "reviewCount", column = "review_count"),
            @Result(property = "yelpingSince", column = "yelping_since"),
            @Result(property = "useful", column = "useful"),
            @Result(property = "funny", column = "funny"),
            @Result(property = "cool", column = "cool"),
            @Result(property = "fans", column = "fans"),
            @Result(property = "averageStars", column = "average_stars"),
            @Result(property = "complimentHot", column = "compliment_hot"),
            @Result(property = "complimentMore", column = "compliment_more"),
            @Result(property = "complimentProfile", column = "compliment_profile"),
            @Result(property = "complimentCute", column = "compliment_cute"),
            @Result(property = "complimentList", column = "compliment_list"),
            @Result(property = "complimentNote", column = "compliment_note"),
            @Result(property = "complimentPlain", column = "compliment_plain"),
            @Result(property = "complimentCool", column = "compliment_cool"),
            @Result(property = "complimentFunny", column = "compliment_funny"),
            @Result(property = "complimentWriter", column = "compliment_writer"),
            @Result(property = "complimentPhotos", column = "compliment_photos")
    })
    public UserEntity findUserById(String id);
}
