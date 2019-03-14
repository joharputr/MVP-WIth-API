package com.example.binarmvp

import android.app.Application
import com.example.binarmvp.network.ApiService
import com.example.binarmvp.network.NetworkConfig

class BinarMvp:Application() {
    companion object {
        lateinit var api:ApiService
    }

    override fun onCreate() {
        super.onCreate()
        api = NetworkConfig.getRetrofit().create(ApiService::class.java)
    }
}