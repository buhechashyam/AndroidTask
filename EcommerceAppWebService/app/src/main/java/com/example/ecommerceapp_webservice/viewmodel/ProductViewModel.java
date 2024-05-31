package com.example.ecommerceapp_webservice.viewmodel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.ecommerceapp_webservice.model.Categories;
import com.example.ecommerceapp_webservice.api.json.ApiService;
import com.example.ecommerceapp_webservice.model.PostProductModel;
import com.example.ecommerceapp_webservice.model.Product;
import com.example.ecommerceapp_webservice.api.json.RetrofitClient;
import com.example.ecommerceapp_webservice.model.UserModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductViewModel extends ViewModel {
    ApiService apiService = RetrofitClient.getRetrofitInstance().create(ApiService.class);

    //All Products
    MutableLiveData<List<Product>> _mProductsList = new MutableLiveData<>();
    LiveData<List<Product>> mProductsList = _mProductsList;

    public LiveData<List<Product>> getProductsList() {

        apiService.getAllProducts().enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {

                List<Product> result = response.body();
                _mProductsList.setValue(result);
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {

            }
        });


        return mProductsList;
    }

    //All Categories
    MutableLiveData<List<Categories>> _mListCategories = new MutableLiveData<>();
    LiveData<List<Categories>> mListCategories = _mListCategories;

    public LiveData<List<Categories>> getCategories() {
        apiService.getCategories().enqueue(new Callback<List<Categories>>() {
            @Override
            public void onResponse(Call<List<Categories>> call, Response<List<Categories>> response) {
                _mListCategories.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Categories>> call, Throwable t) {

            }
        });
        return mListCategories;
    }

    // Post Request - Add product
    MutableLiveData<Boolean> _mAddProductResponse = new MutableLiveData<>();
    LiveData<Boolean> mAddProductResponse = _mAddProductResponse;
    public LiveData<Boolean> addProduct(PostProductModel product) {
        apiService.addProduct(product).enqueue(new Callback<Product>() {
            @Override
            public void onResponse(Call<Product> call, Response<Product> response) {
                _mAddProductResponse.setValue(true);

                Log.d("MAIN", String.valueOf(response.body().getid()));
            }

            @Override
            public void onFailure(Call<Product> call, Throwable t) {
                _mAddProductResponse.setValue(true);
            }
        });
        return mAddProductResponse;
    }

    //Put - update

    MutableLiveData<Product> _updatedProduct = new MutableLiveData<>();
    LiveData<Product> updateProduct = _updatedProduct;
    public LiveData<Product> updateProduct(int id,PostProductModel product) {
        apiService.updateProduct(id,product).enqueue(new Callback<Product>() {
            @Override
            public void onResponse(Call<Product> call, Response<Product> response) {
                _updatedProduct.setValue(response.body());
            }

            @Override
            public void onFailure(Call<Product> call, Throwable t) {

            }
        });
        return updateProduct;
    }

    //get specific users from api
    MutableLiveData<List<UserModel>> _usersList = new MutableLiveData<>();
    LiveData<List<UserModel>> usersList = _usersList;

    public LiveData<List<UserModel>> getUsers(int limit) {

        apiService.getSpecificUsers(limit).enqueue(new Callback<List<UserModel>>() {
            @Override
            public void onResponse(Call<List<UserModel>> call, Response<List<UserModel>> response) {
                _usersList.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<UserModel>> call, Throwable t) {

            }
        });
        return usersList;
    }


    MutableLiveData<UserModel> _deletedUserData = new MutableLiveData<>();
    LiveData<UserModel> deletedUser = _deletedUserData;

    public LiveData<UserModel> deleteUser(int id) {

        apiService.deleteUser(id).enqueue(new Callback<UserModel>() {
            @Override
            public void onResponse(Call<UserModel> call, Response<UserModel> response) {
                _deletedUserData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<UserModel> call, Throwable t) {

            }
        });

        return deletedUser;
    }
}
