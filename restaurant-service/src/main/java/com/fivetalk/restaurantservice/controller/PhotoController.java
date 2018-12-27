package com.fivetalk.restaurantservice.controller;

import com.fivetalk.restaurantservice.model.RestaurantPhotoEntity;
import com.fivetalk.restaurantservice.service.RestaurantPhotoService;
import com.fivetalk.restaurantservice.util.ResponseMsg;
import com.fivetalk.restaurantservice.util.ResponseUtil;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/photo")
public class PhotoController {
    @Autowired
    private RestaurantPhotoService restaurantPhotoService;

    private static Gson gson = new Gson();
    private ResponseUtil responseUtil = new ResponseUtil();

    @RequestMapping(value = "/getRestaurantPhotos", method = RequestMethod.GET)
    public String getSomeRestaurantPhotos(@RequestParam(value = "page", required = true, defaultValue = "1") int page,
                                          @RequestParam(value = "size", required = true, defaultValue = "10") int size) {
        List<RestaurantPhotoEntity> photoList = restaurantPhotoService.getSomeRestaurantPhotos(page, size);
        ResponseMsg responseMsg = responseUtil.success(photoList);
        return gson.toJson(responseMsg);
    }

    @RequestMapping(value = "/getRestaurantPhotosByRestaurantId", method = RequestMethod.GET)
    public String getRestaurantPhotosByBusinessId(@RequestParam(value = "restaurant_id") String restaurantId) {
        List<RestaurantPhotoEntity> photoList = restaurantPhotoService.getRestaurantPhotosByBusinessId(restaurantId);
        ResponseMsg responseMsg = responseUtil.success(photoList);
        return gson.toJson(responseMsg);
    }

    @RequestMapping(value = "/getRestaurantPhotosById", method = RequestMethod.GET)
    public String getRestaurantPhotosById(@RequestParam(value = "photo_id")String id) {
        RestaurantPhotoEntity r = restaurantPhotoService.findRestaurantPhotosById(id);
        ResponseMsg responseMsg = responseUtil.success(r);
        return gson.toJson(responseMsg);
    }

}
