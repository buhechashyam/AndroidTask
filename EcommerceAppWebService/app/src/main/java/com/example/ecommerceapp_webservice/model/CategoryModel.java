package com.example.ecommerceapp_webservice.model;

import java.util.List;

public class CategoryModel {
    String mCategory;
    List<Product> mCategoryList;

    public CategoryModel(String mCategory, List<Product> mCategoryList) {
        this.mCategory = mCategory;
        this.mCategoryList = mCategoryList;
    }

    public String getmCategory() {
        return mCategory;
    }

    public void setmCategory(String mCategory) {
        this.mCategory = mCategory;
    }

    public List<Product> getmCategoryList() {
        return mCategoryList;
    }

    public void setmCategoryList(List<Product> mCategoryList) {
        this.mCategoryList = mCategoryList;
    }
}
