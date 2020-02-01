package com.example.munazamfyp.Interfaces;
import com.example.munazamfyp.DataModels.CourseModel;
import com.example.munazamfyp.DataModels.ReminderItem;
import com.example.munazamfyp.DataModels.ReminderModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
public interface ReminderInterface
{

    //@GetMapping("/reminder/{usrid}/{type}/{date}/{time}/{coursename}")
    @GET("/reminder/{usrid}/{type}/{date}/{time}/{coursename}/{prio}")
    Call<String> putdata(@Path("usrid") String id, @Path("type") String type, @Path("date") String date, @Path("time") String time, @Path("coursename") String CN,@Path("prio") String prio);

    @GET("/reminder/{id}")
    Call<ArrayList<ReminderModel>> getdata(@Path("id") String id);

    @GET("/deletereminder/{id}")
    public Call<String> datad(@Path("id") String id);

    @GET("/getcourses/{id}")
    public Call<ArrayList<CourseModel>> getcourses(@Path("id") String id);

    @GET("/setcourses/{name}/{section}/{usrid}")
    public Call<String> setcourses(@Path("name") String name,@Path("section") String section,@Path("usrid") String usrid);
}
