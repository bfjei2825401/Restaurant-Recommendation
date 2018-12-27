package com.fivetalk.recommendationservice.model;

import java.sql.Timestamp;

public class ReviewEntity {
    private String id;
    private int stars;
    private Timestamp date;
    private String text;
    private int useful;
    private int funny;
    private int cool;
    private String businessId;
    private String userId;

    public ReviewEntity(String id, int stars, String businessId, String userId) {
        this.id = id;
        this.stars = stars;
        this.businessId = businessId;
        this.userId = userId;
    }

    public ReviewEntity(String id, int stars, Timestamp date, String text, int useful, int funny, int cool, String businessId, String userId) {
        this.id = id;
        this.stars = stars;
        this.date = date;
        this.text = text;
        this.useful = useful;
        this.funny = funny;
        this.cool = cool;
        this.businessId = businessId;
        this.userId = userId;
    }

    public ReviewEntity(String id, int stars, int useful, int funny, int cool, String businessId, String userId) {
        this.id = id;
        this.stars = stars;
        this.useful = useful;
        this.funny = funny;
        this.cool = cool;
        this.businessId = businessId;
        this.userId = userId;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public int getUseful() {
        return useful;
    }

    public void setUseful(int useful) {
        this.useful = useful;
    }

    public int getFunny() {
        return funny;
    }

    public void setFunny(int funny) {
        this.funny = funny;
    }

    public int getCool() {
        return cool;
    }

    public void setCool(int cool) {
        this.cool = cool;
    }

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
