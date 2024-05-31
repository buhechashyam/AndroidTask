package com.example.materialuicomponent.recyclerview.model;

import android.widget.ImageView;
import android.widget.TextView;

public class Product {
    int productImg;
    String productName;
    int productPrice;

    public int getProductImg() {
        return productImg;
    }

    public void setProductImg(int productImg) {
        this.productImg = productImg;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public Product(int productImg, String productName, int productPrice){
        this.productImg = productImg;
        this.productName =productName;
        this.productPrice = productPrice;
    }


}


