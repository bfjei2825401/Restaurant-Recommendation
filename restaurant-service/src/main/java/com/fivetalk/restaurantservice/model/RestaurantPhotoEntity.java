package com.fivetalk.restaurantservice.model;

public class RestaurantPhotoEntity {
    private String id;
    private String businessId;
    private String caption;
    private String label;
    private String url;

    public RestaurantPhotoEntity(String id, String businessId, String caption, String label) {
        this.id = id;
        this.businessId = businessId;
        this.caption = caption;
        this.label = label;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
