package com.example.binarmvp.network

import com.example.binarmvp.model.NewStudentResponse
import com.example.binarmvp.model.StudentResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface ApiService {

    @GET("api/v1/student/all")
    fun getAllStudents():Call<StudentResponse>


    @Headers("Content-Type: application/json")
    @POST("api/v1/student/")
    fun newStudent(@Body studentMap:Map<String, String>) :Call<NewStudentResponse>

}