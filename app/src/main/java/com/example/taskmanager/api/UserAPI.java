package com.example.taskmanager.api;

import com.example.taskmanager.model.User;
import com.example.taskmanager.serverResponse.ImageResponse;
import com.example.taskmanager.serverResponse.SignUpResponse;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface UserAPI {

    @POST("users/sigup")
    Call<SignUpResponse> registerUser(@Body User user);

    @FormUrlEncoded
    @POST("users/login")
    Call<ImageResponse> uploadImage(@Field("username") String username, @Field("password") String password);

    @Multipart
    @POST("upload")
    Call<ImageResponse> uploadImage(@Part MultipartBody.Part image);

    @GET("users/me")
    Call<User> getUserDetails(@Header("Authorization") String token);

}
