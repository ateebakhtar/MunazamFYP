package com.example.munazamfyp.Interfaces;

import java.sql.SQLException;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface MeetingInterface
{

    @GET("/meeting/{course}/{name}/{id}/{venue}/{time}/{date}/{capacity}/{topic}/{description}")
    Call<String> addmeeting(@Path("course") String course,@Path("name") String name,@Path("id") String id,@Path("venue") String venue,@Path("time") String time,@Path("date") String date,@Path("capacity") String capacity,@Path("topic") String topic,@Path("description") String description) ;

}
