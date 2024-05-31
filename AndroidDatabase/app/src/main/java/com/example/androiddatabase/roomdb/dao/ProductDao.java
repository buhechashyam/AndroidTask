package com.example.androiddatabase.roomdb.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Ignore;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.androiddatabase.roomdb.entity.ProductEntity;

import java.util.List;

@Dao
public interface ProductDao {
    @Insert
    void addProduct(ProductEntity product);

    @Update
    void updateProduct(ProductEntity product);

    //Update Record By Id
    @Query("UPDATE products_table SET product_name = :pname, product_desc = :pDesc, product_price = :pPrice WHERE id = :id")
    void updateProductById(int id, String pname, String pDesc, String pPrice);

    @Delete
    void deleteProduct(ProductEntity product);

    //Get All Data From Table
    @Query("SELECT * FROM products_table")
    List<ProductEntity> getAllProducts();

    //Delete All records
    @Query("DELETE FROM products_table")
    void deleteAllRecords();


   }
