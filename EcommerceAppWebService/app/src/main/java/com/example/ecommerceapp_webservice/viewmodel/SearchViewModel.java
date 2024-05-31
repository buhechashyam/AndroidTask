package com.example.ecommerceapp_webservice.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.ecommerceapp_webservice.api.xml.XmlApiService;
import com.example.ecommerceapp_webservice.api.xml.XmlRetrofitClient;
import com.example.ecommerceapp_webservice.model.xmlmodel.TrendingSearchItem;
import com.example.ecommerceapp_webservice.model.xmlmodel.TrendingSearchResponseWrapper;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchViewModel extends ViewModel {

    XmlApiService apiService = XmlRetrofitClient.getRetrofitInstance().create(XmlApiService.class);
    MutableLiveData<List<TrendingSearchItem>> _trendSearchItems = new MutableLiveData<>();
    LiveData<List<TrendingSearchItem>> trendSearchItems = _trendSearchItems;

    public LiveData<List<TrendingSearchItem>> getTrendSearchItems() {
        apiService.getTrendSearches("IN").enqueue(new Callback<TrendingSearchResponseWrapper>() {
            @Override
            public void onResponse(Call<TrendingSearchResponseWrapper> call, Response<TrendingSearchResponseWrapper> response) {
                _trendSearchItems.setValue(response.body().getChannel().getItemList());
            }

            @Override
            public void onFailure(Call<TrendingSearchResponseWrapper> call, Throwable t) {

            }
        });

        return trendSearchItems;
    }
}
