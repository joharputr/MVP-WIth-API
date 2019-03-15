package com.example.binarmvp.model

import com.google.gson.annotations.SerializedName

data class NewStudentResponse(
    @field:SerializedName("status")
    val status:String,
    @field:SerializedName("data")
    val data:Student?,  //karena json objek pake kurung kurawal
    @field:SerializedName("error")
    val error:ErrorResponse?
)
