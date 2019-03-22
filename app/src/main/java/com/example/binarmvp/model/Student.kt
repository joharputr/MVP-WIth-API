package com.example.binarmvp.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Student(
    @field:SerializedName("id")
    val id:Int,
    @field:SerializedName("name")
    val name :String,
    @field:SerializedName("email")
    val email:String):Parcelable