package com.example.binarmvp.network

import com.example.binarmvp.BuildConfig
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object NetworkConfig {
    fun getRetrofit():Retrofit{
        return  Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(getOkHttpClient()) //retrofit butuh client
            .build()
    }
    //client
    private fun getOkHttpClient(): OkHttpClient {
        val timeOut = 60L
        return OkHttpClient.Builder()
            .readTimeout(timeOut, TimeUnit.SECONDS)
            .connectTimeout(timeOut, TimeUnit.SECONDS)
            .writeTimeout(timeOut, TimeUnit.SECONDS)
            .addInterceptor(getInterseptor())  //client butuh interseptor
            .build()
    }

    //interseptor
    //muncul di logcat
    private fun getInterseptor(): Interceptor {
        return HttpLoggingInterceptor().apply {//pake run eror why?
            level = if (BuildConfig.DEBUG){
                HttpLoggingInterceptor.Level.BODY
            }else{
                HttpLoggingInterceptor.Level.NONE
            }
        }

        //style java
        /*val interseptor = HttpLoggingInterceptor()
        interseptor.level =  if (BuildConfig.DEBUG){
            HttpLoggingInterceptor.Level.BODY
        }else{
            HttpLoggingInterceptor.Level.NONE
        }*/
    }
}