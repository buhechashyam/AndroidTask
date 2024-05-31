package com.example.ecommerceapp_webservice.model;

public class ProductCategoryModel {

    int mCategoryImage;
    String mCategoryName;

    public ProductCategoryModel(int mCategoryImage, String mCategoryName) {
        this.mCategoryImage = mCategoryImage;
        this.mCategoryName = mCategoryName;
    }

    public int getmCategoryImage() {
        return mCategoryImage;
    }

    public void setmCategoryImage(int mCategoryImage) {
        this.mCategoryImage = mCategoryImage;
    }

    public String getmCategoryName() {
        return mCategoryName;
    }

    public void setmCategoryName(String mCategoryName) {
        this.mCategoryName = mCategoryName;
    }
}
