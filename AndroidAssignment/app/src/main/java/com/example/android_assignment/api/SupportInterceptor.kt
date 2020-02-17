package com.example.android_assignment.api

import okhttp3.Interceptor
import okhttp3.Response

class SupportInterceptor: Interceptor{

    private val userAgent = System.getProperty("http.agent")
    //private val deviceId =

    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        request = request.newBuilder()
            .addHeader("User-Agent", userAgent!!)
            //?.addHeader("Device-ID ")
            .build()
        return chain.proceed(request)
    }
}