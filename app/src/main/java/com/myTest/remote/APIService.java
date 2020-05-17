package com.myTest.remote;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by ronak.b on 17/5/2020.
 */

public interface APIService {

    @FormUrlEncoded
    @POST("/")
    Call<String> userLogin (@Field("username") String username, @Field("password") String password);

}
