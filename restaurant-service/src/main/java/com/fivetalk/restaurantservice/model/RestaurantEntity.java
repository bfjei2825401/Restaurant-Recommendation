package com.fivetalk.restaurantservice.model;

import com.google.gson.Gson;

public class RestaurantEntity {
    private String id;
    private String name;
    private String neighborhood;
    private String address;
    private String city;
    private String state;
    private String postalCode;
    private float latitude;
    private float longtitude;
    private float stars;
    private int reviewCount;
    private int isOpen;

    public RestaurantEntity(String id, String name, String neighborhood, String address, String city, String state, String postalCode, float latitude, float longtitude, float stars, int reviewCount, int isOpen) {
        this.id = id;
        this.name = name;
        this.neighborhood = neighborhood;
        this.address = address;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.latitude = latitude;
        this.longtitude = longtitude;
        this.stars = stars;
        this.reviewCount = reviewCount;
        this.isOpen = isOpen;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(float longtitude) {
        this.longtitude = longtitude;
    }

    public float getStars() {
        return stars;
    }

    public void setStars(float stars) {
        this.stars = stars;
    }

    public int getReviewCount() {
        return reviewCount;
    }

    public void setReviewCount(int reviewCount) {
        this.reviewCount = reviewCount;
    }

    public int getIsOpen() {
        return isOpen;
    }

    public void setIsOpen(int isOpen) {
        this.isOpen = isOpen;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"id\":\"")
                .append(id).append('\"');
        sb.append(",\"name\":\"")
                .append(name).append('\"');
        sb.append(",\"neighborhood\":\"")
                .append(neighborhood).append('\"');
        sb.append(",\"address\":\"")
                .append(address).append('\"');
        sb.append(",\"city\":\"")
                .append(city).append('\"');
        sb.append(",\"state\":\"")
                .append(state).append('\"');
        sb.append(",\"postalCode\":\"")
                .append(postalCode).append('\"');
        sb.append(",\"latitude\":")
                .append(latitude);
        sb.append(",\"longtitude\":")
                .append(longtitude);
        sb.append(",\"stars\":")
                .append(stars);
        sb.append(",\"reviewCount\":")
                .append(reviewCount);
        sb.append(",\"isOpen\":")
                .append(isOpen);
        sb.append('}');
        return sb.toString();
    }

    public String toJson() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
