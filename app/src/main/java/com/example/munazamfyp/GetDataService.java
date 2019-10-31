package com.example.munazamfyp;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GetDataService
{
    @GET("user/{id}")
    Call<String> Get(@Path("id") String id);

    @GET("sendmail")
    Call<String> Get();
}
