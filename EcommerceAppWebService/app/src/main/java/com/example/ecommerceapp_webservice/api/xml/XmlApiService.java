package com.example.ecommerceapp_webservice.api.xml;

import com.example.ecommerceapp_webservice.model.xmlmodel.TrendingSearchResponseWrapper;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface XmlApiService {

    @GET("rss")
    Call<TrendingSearchResponseWrapper> getTrendSearches(@Query("geo") String countryCode);

}
