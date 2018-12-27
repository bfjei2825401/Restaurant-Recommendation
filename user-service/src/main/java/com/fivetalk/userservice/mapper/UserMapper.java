package com.fivetalk.userservice.mapper;

import com.fivetalk.userservice.model.UserEntity;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

    //    @Insert("INSERT INTO user_info(user_name,password,nick_name,head_url) VALUES(#{username},#{password},#{nickName},#{headUrl})")
//    boolean insertUserByAll(UserEntity userEntity);
//
    @Update("UPDATE user_info SET name=#{name} WHERE id=#{id}")
    void updateName(String id, String name);

    @Update("UPDATE user_info SET password=#{password} WHERE id=#{id}")
    void updatePassword(String id, String password);

    @Update("UPDATE user_info SET head_url=#{headUrl} WHERE id=#{id}")
    void updateHeadUrl(String id, String headUrl);

    @Delete("DELETE FROM user_info WHERE id=#{id}")
    void deleteUser(String id);


    @Select("SELECT * FROM user_info LIMIT #{limit},#{offset}")
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
            @Result(property = "complimentPhotos", column = "compliment_photos"),
            @Result(property = "username", column = "username"),
            @Result(property = "headUrl", column = "head_url")
    })
    List<UserEntity> getSomeUsers(int limit, int offset);

    @Select("SELECT * FROM user_info WHERE id=#{id}")
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
            @Result(property = "complimentPhotos", column = "compliment_photos"),
            @Result(property = "username", column = "username"),
            @Result(property = "headUrl", column = "head_url")
    })
    UserEntity findUserById(String id);

    @Select("SELECT * FROM user_info WHERE username=#{username} AND password=#{password}")
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
            @Result(property = "complimentPhotos", column = "compliment_photos"),
            @Result(property = "username", column = "username"),
            @Result(property = "headUrl", column = "head_url")
    })
    UserEntity findUserByUsernamePassword(String username, String password);
}
