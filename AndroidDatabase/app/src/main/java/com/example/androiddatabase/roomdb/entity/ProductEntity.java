package com.example.androiddatabase.roomdb.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "products_table")
public class ProductEntity {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "product_name")
    private String productName;
    @ColumnInfo(name = "product_desc")
    private String productDescription;
    @ColumnInfo(name = "product_price")
    private String productPrice;

    //if id is not auto generated that time this constructor use

//    public ProductEntity(int id, String productName, String productDescription, String productPrice) {
//        this.id = id;
//        this.productName = productName;
//        this.productDescription = productDescription;
//        this.productPrice = productPrice;
//    }

    //if id is auto generated than this constructor use
    public ProductEntity(String productName, String productDescription, String productPrice) {
        this.productName = productName;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }
}
