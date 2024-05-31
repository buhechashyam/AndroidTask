package com.example.ecommerceapp_webservice.api.xml;

import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class XmlRetrofitClient {

    public static String BASE_URL = "https://trends.google.com/trends/trendingsearches/daily/";

    public static Retrofit retrofit = null;

    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(SimpleXmlConverterFactory.create()).build();
        }
        return retrofit;
    }
}
