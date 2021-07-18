package com.codeup.adlister.models;

public class Category {
    private long ad_id;
//    private long cat_id;
    private String category;

    public Category(){};

    public String getCategory() {
        return category;
    }

//    public Category(String category) {
//        this.category = category;
//    }

//    public Category(long ad_id, long cat_id) {
//        this.ad_id = ad_id;
//        this.cat_id = cat_id;
//    }
    public Category(long ad_id, String category) {
        this.ad_id = ad_id;
        this.category = category;
    }

//    public Category(long ad_id, long cat_id, String category) {
//        this.ad_id = ad_id;
//        this.cat_id = cat_id;
//        this.category = category;
//    }

    public long getAd_id() {
        return ad_id;
    }

    public void setAd_id(long ad_id) {
        this.ad_id = ad_id;
    }

//    public long getCat_id() {
//        return cat_id;
//    }

//    public void setCat_id(long cat_id) {
//        this.cat_id = cat_id;
//    }
}
