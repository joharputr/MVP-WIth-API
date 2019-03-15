package com.example.binarmvp.model

import com.google.gson.annotations.SerializedName

data class Student(
    @field:SerializedName("id")
    val id:Int,
    @field:SerializedName("name")
    val name :String,
    @field:SerializedName("email")
    val email:String)