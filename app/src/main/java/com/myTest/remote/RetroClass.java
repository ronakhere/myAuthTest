package com.myTest.remote;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ronak.b on 17/5/2020.
 */

public class RetroClass {
    private static final String BASE_URL = "https://dev-369378.okta.com";

    private static Retrofit getRetroInstance() {
        Gson gson = new GsonBuilder().setLenient().create();
        return new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create(gson)).build();
    }

    public static APIService getAPIService() {
        return getRetroInstance().create(APIService.class);
    }
}
