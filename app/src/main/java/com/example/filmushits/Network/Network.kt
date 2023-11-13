package com.example.filmushits.Network

import com.example.filmushits.Network.Auth.AuthApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

object Network {
    private const val BASE_URL = "https://react-midterm.kreosoft.space/"

    private fun getRetrofit(): Retrofit {

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .client(getHttpClient())
            .build()
    }

    var token = ""
    var userid = ""

    private val retrofit: Retrofit = getRetrofit()

    private fun getHttpClient(): OkHttpClient {
        val client = OkHttpClient.Builder().apply {
            connectTimeout(15, TimeUnit.SECONDS)
            readTimeout(60, TimeUnit.SECONDS)
            writeTimeout(60, TimeUnit.SECONDS)
            retryOnConnectionFailure(false)
            addInterceptor(MyInterceptor())
            val logLevel = HttpLoggingInterceptor.Level.BODY
            addInterceptor(HttpLoggingInterceptor().setLevel(logLevel))
        }
        return client.build()
    }

    fun getAuthApi(): AuthApi.AuthApi = retrofit.create(AuthApi.AuthApi::class.java)


}


