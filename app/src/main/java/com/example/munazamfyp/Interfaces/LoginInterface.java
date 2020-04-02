package com.example.munazamfyp.Interfaces;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
public interface LoginInterface
{
    @GET("login/{id}/{name}/{pass}/{sem}")
    Call<String> Get(@Path("id") String id,@Path("name") String name,@Path("pass") String pass,@Path("sem")String sem);

    @GET("/getsemester/{id}")
    Call<String> getsemester(@Path("id") String id);

    @GET("/sendmail/{id}")
    Call<String> emailverify(@Path("id") String id);

    @GET("/getconnection")
    Call<String> getconnection();

    @GET("login/{name}/{pass}")
    Call<String> Getlogin(@Path("name") String name,@Path("pass") String pass);

    @GET("editlogin/{name}/{pass}/{id}")
    Call<String> getedit(@Path("name") String name, @Path("pass") String pass, @Path("id") String id);

    @GET("forgetpassword/{id}")
    Call<String> forgotpass(@Path("id") String id);
}
