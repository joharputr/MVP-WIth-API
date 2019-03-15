package com.example.binarmvp.model

import com.google.gson.annotations.SerializedName
import retrofit2.http.Field


data class ErrorResponse(
    @field:SerializedName("message")
    val message:String,
   @field:SerializedName("code")
    val code :Int)