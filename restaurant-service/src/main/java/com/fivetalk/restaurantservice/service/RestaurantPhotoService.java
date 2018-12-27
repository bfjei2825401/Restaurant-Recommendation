package com.fivetalk.restaurantservice.service;

import com.fivetalk.restaurantservice.model.RestaurantPhotoEntity;

import java.util.List;

public interface RestaurantPhotoService {
    List<RestaurantPhotoEntity> getSomeRestaurantPhotos(int page, int size);

    RestaurantPhotoEntity findRestaurantPhotosById(String id);

    List<RestaurantPhotoEntity> getRestaurantPhotosByBusinessId(String businessId);

}
