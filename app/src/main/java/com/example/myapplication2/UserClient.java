package com.example.myapplication2;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface UserClient {
    @Headers({"Content-Type: application/json"})
    @POST("test2")
    Call<UserResponse> userLogin(@Body User user);

    //@GET("test")
    //Call<UserResponse> getSecret(@Header("Authorization") String authToken);
}
