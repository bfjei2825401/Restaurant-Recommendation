package com.fivetalk.restaurantservice.service.impl;

import com.fivetalk.restaurantservice.mapper.RestaurantPhotoMapper;
import com.fivetalk.restaurantservice.model.RestaurantPhotoEntity;
import com.fivetalk.restaurantservice.service.RestaurantPhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.util.List;
@Service
public class RestaurantPhotoServiceImpl implements RestaurantPhotoService {
    @Autowired
    private RestaurantPhotoMapper restaurantPhotoMapper;

    @Override
    public List<RestaurantPhotoEntity> getSomeRestaurantPhotos(int page, int size) {
        int limit = (page - 1) * size;
        List<RestaurantPhotoEntity> list = restaurantPhotoMapper.getSomeRestaurantPhotos(limit, size);
        setUrl(list);
        return list;
    }

    @Override
    public RestaurantPhotoEntity findRestaurantPhotosById(String id) {
        RestaurantPhotoEntity restaurantPhotoEntity = restaurantPhotoMapper.findRestaurantPhotoById(id);
        setUrl(restaurantPhotoEntity);
        return restaurantPhotoEntity;
    }

    @Override
    public List<RestaurantPhotoEntity> getRestaurantPhotosByBusinessId(String businessId) {
        List<RestaurantPhotoEntity> list = restaurantPhotoMapper.findRestaurantPhotosByBusinessId(businessId);
        setUrl(list);
        return list;
    }

    private void setUrl(List<RestaurantPhotoEntity> list) {
        for (RestaurantPhotoEntity r : list) {
            setUrl(r);
        }
    }

    private void setUrl(RestaurantPhotoEntity r) {
        r.setUrl("/image/" + r.getId() + ".jpg");
    }

}
