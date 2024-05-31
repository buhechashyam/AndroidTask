package com.example.ecommerceapp_webservice.model;

public class ProductModel {
    String mCategoryName;
    String mProductName;
    int mProductImage;
    int mProductPrice;
    String mProductDescription;

    public ProductModel(String mCategoryName, String mProductName, int mProductImage, int mProductPrice, String mProductDescription) {
        this.mCategoryName = mCategoryName;
        this.mProductName = mProductName;
        this.mProductImage = mProductImage;
        this.mProductPrice = mProductPrice;
        this.mProductDescription = mProductDescription;
    }

    public String getmCategoryName() {
        return mCategoryName;
    }

    public void setmCategoryName(String mCategoryName) {
        this.mCategoryName = mCategoryName;
    }

    public String getmProductName() {
        return mProductName;
    }

    public void setmProductName(String mProductName) {
        this.mProductName = mProductName;
    }

    public int getmProductImage() {
        return mProductImage;
    }

    public void setmProductImage(int mProductImage) {
        this.mProductImage = mProductImage;
    }

    public int getmProductPrice() {
        return mProductPrice;
    }

    public void setmProductPrice(int mProductPrice) {
        this.mProductPrice = mProductPrice;
    }

    public String getmProductDescription() {
        return mProductDescription;
    }

    public void setmProductDescription(String mProductDescription) {
        this.mProductDescription = mProductDescription;
    }
}
