package com.example.munazamfyp;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetDataService
{
    @GET("home")
    Call<String> Get();
}
