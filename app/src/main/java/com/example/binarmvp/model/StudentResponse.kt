package com.example.binarmvp.model

import com.google.gson.annotations.SerializedName

data class StudentResponse(
    @field:SerializedName("status")
    val status:String,
    @field:SerializedName("data")
    val data:List<Student>?,
    @field:SerializedName("error")
    val error:ErrorResponse?
    )
