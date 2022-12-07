package com.example.myapplication2;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ0b2tlbl90eXBlIjoiYWNjZXNzIiwiZXhwIjoxNzU1Njg4Mjc1LCJpYXQiOjE2NjkyODgyNzUsImp0aSI6IjY1NWNkZGMyMTlmZTRhZGQ5NjIwODI5MzFlM2ViZTk2IiwidXNlcl9pZCI6ImVpbiJ9.1R-FH_Yxzxogf1uWsEuzeUHBDgY5PLn6uVfyKCyT8tM";

    public ApiClient(String token) {
        this.token = token;
    }
    static UserClient getRetrofit() {
        //create Okhttp client
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request newRequest = chain.request().newBuilder()
                                .addHeader("Authorization","Bearer "+ token)
                                .build();
                        return chain.proceed(newRequest);
                    }
                }).build();

        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl("https://test.recycleledger.com/qldb/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //get client & call object for the request
        UserClient userclient = retrofit.create(UserClient.class);
        //Call<User> call = userclient.createAccount(user);
        return userclient;
    }

}
