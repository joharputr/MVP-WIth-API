package com.example.binarmvp.network

import com.example.binarmvp.model.NewStudentResponse
import com.example.binarmvp.model.StudentResponse
import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    //yang pake @ namanya anotasi dan harus pake tempat untuk nempel\
    //yang di dalam <> = generic programming
    @GET("api/v1/student/all")
    fun getAllStudents(): Call<StudentResponse>

    @Headers("Content-Type: application/json")
    @POST("api/v1/student/")
    fun newStudent(@Body studentMap: Map<String, String>): Call<NewStudentResponse>

    @DELETE("/api/v1/student/{id}")
    fun deleteStudent(@Path("id") id: Int): Call<NewStudentResponse>

    @PUT("/api/v1/student/{id}")
    fun editStudent(
        @Path("id") id: Int,
        @Body map: Map<String, String>
    ): Call<NewStudentResponse>
}