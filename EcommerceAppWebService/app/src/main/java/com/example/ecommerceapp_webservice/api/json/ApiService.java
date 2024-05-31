package com.example.ecommerceapp_webservice.api.json;

import com.example.ecommerceapp_webservice.model.Categories;
import com.example.ecommerceapp_webservice.model.PostProductModel;
import com.example.ecommerceapp_webservice.model.Product;
import com.example.ecommerceapp_webservice.model.UserModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {

    @GET("products")
    Call<List<Product>> getAllProducts();

    //Request with path parameter
    @GET("products/{category}")
    Call<List<Product>> getProductsByCategory(@Path("category") String category);

    @GET("products/categories")
    Call<List<Categories>> getCategories();

    @POST("products")
    Call<Product> addProduct(@Body PostProductModel product);

    @PUT("products/{id}")
    Call<Product> updateProduct(@Path("id") int id, @Body PostProductModel product);

    //Get request with query. get specific users from api
    @GET("users")
    Call<List<UserModel>> getSpecificUsers(@Query("limit") int limit);

    @DELETE("users/{id}")
    Call<UserModel> deleteUser(@Path("id") int id);

}
