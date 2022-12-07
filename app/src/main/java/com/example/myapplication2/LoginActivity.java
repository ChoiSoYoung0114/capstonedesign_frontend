package com.example.myapplication2;
//package mommoo.com.httpurlconnection;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.annotation.SuppressLint;
import android.content.Intent;
// import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
// import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
// import io.jsonwebtoken.JwtBuilder;
// import io.jsonwebtoken.Jwts;
// import io.jsonwebtoken.SignatureAlgorithm;
//import io.jsonwebtoken.security.Keys;
//import java.security.Key;
//import java.util.Date;
//import android.database.Cursor;
import android.widget.Toast;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
//import android.graphics.Bitmap;
//import android.graphics.BitmapFactory;
//import android.graphics.drawable.BitmapDrawable;
//import android.net.Uri;
//import android.provider.MediaStore;
//import android.widget.ImageView;
//import java.io.ByteArrayOutputStream;
//import org.json.JSONArray;
//import org.json.JSONObject;

//import android.support.design.widget.FloatingActionButton;
//import android.support.design.widget.Snackbar;
//import android.support.v7.app.AppCompatActivity;
//import android.support.v7.widget.Toolbar;


@SuppressWarnings("ALL")
public class LoginActivity extends AppCompatActivity {
    private String authToken;

    //public EditText idText, passwordText;
    //public static String id, password;
    //private TextView tv_outPut;
    //private TextView textViewResult;

    @SuppressLint("StaticFieldLeak")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText idText = (EditText) findViewById(R.id.idText);
        final EditText passwordText = (EditText) findViewById(R.id.passwordText);

        TextView registerButton = (TextView) findViewById(R.id.registerButton);
        AppCompatButton loginButton = (AppCompatButton) findViewById(R.id.loginButton);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent registerIntent = new Intent(LoginActivity.this, RegisterActivity.class);
                LoginActivity.this.startActivity(registerIntent);
            }
        });


        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //saveUser(createRequest());

                Intent loginIntent = new Intent(LoginActivity.this, MainActivity.class);
                LoginActivity.this.startActivity(loginIntent);

                User user = new User(
                        idText.getText().toString(),
                        passwordText.getText().toString()
                );

                sendNetworkRequest(user);

            }
        });

    }

    /*private static String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ0b2tlbl90eXBlIjoiYWNjZXNzIiwiZXhwIjoxNzU1Njg4Mjc1LCJpYXQiOjE2NjkyODgyNzUsImp0aSI6IjY1NWNkZGMyMTlmZTRhZGQ5NjIwODI5MzFlM2ViZTk2IiwidXNlcl9pZCI6ImVpbiJ9.1R-FH_Yxzxogf1uWsEuzeUHBDgY5PLn6uVfyKCyT8tM";

    public LoginActivity(String token) {
        this.token = token;
    }*/

    private void sendNetworkRequest(User user) {
        //create Okhttp client
        //OkHttpClient.Builder okhttpClientBuilder =  new OkHttpClient.Builder();

        //HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        //logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        //okhttpClientBuilder.addInterceptor(logging);

        /*OkHttpClient client = new OkHttpClient.Builder()
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
        UserClient userclient = retrofit.create(UserClient.class);*/
        Call<UserResponse> call = ApiClient.getRetrofit().userLogin(user);
        call.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                Toast.makeText(LoginActivity.this, "Yeah! ---> "+response.body(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "something wrong....:(", Toast.LENGTH_SHORT).show();
            }
        });

    }

    /*public UserRequest createRequest(){
        UserRequest userRequest = new UserRequest();
        userRequest.setIdText(idText.getText().toString());
        userRequest.setPasswordText(passwordText.getText().toString());

        return userRequest;
    }


    public void saveUser(UserRequest userRequest){
        Call<UserResponse> userResponseCall = ApiClient.getUserService().saveUsers(userRequest);
        //System.out.print("----------아이디---------"+idText);
        //System.out.print("----------비밀번호---------"+passwordText);
        userResponseCall.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                if(response.isSuccessful()){
                    Toast.makeText(LoginActivity.this, "Successfully!", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(LoginActivity.this, "Failed...", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "Failed..."+t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }*/
    }
