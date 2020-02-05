package com.example.munazamfyp.Interfaces;

import com.example.munazamfyp.DataModels.AttendeesModel;
import com.example.munazamfyp.DataModels.MeetingModel;

import java.sql.SQLException;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface MeetingInterface
{

    @GET("/meeting/{course}/{name}/{id}/{venue}/{time}/{date}/{capacity}/{topic}/{description}")
    Call<String> addmeeting(@Path("course") String course,@Path("name") String name,@Path("id") String id,@Path("venue") String venue,@Path("time") String time,@Path("date") String date,@Path("capacity") String capacity,@Path("topic") String topic,@Path("description") String description) ;

    @GET("/meetinglist")
    Call<ArrayList<MeetingModel>> getmeeetinglist();

    @GET("/meetinglist/{uniid}")
    Call<ArrayList<MeetingModel>> getmymeeetinglist(@Path("uniid") String uniid);

    @GET("/joinmeeting/{id}/{name}/{uniid}")
    Call<String> joinmeeting(@Path("id") String id,@Path("name") String name,@Path("uniid") String uniid);

    @GET("/getattendees/{id}")
    Call<ArrayList<AttendeesModel>> getattendees(@Path("id") String id);
}
