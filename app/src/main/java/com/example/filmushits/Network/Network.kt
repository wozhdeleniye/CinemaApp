package com.example.filmushits.Network

import androidx.lifecycle.ViewModel
import com.example.filmushits.Etities.RequestBodies.RegisterRequestBody
import com.example.filmushits.Network.Auth.AuthApi
import com.example.filmushits.Network.Favorite.FavoriteApi
import com.example.filmushits.Network.Main.MovieApi
import com.example.filmushits.Network.Profile.ProfileApi
import kotlinx.coroutines.Job
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
class Network {
    private val BASE_URL = "https://react-midterm.kreosoft.space/"
    private lateinit var retrofit: Retrofit
    private lateinit var tokenManager: TokenManager

    fun initialize(){
        this.retrofit = getRetrofit()
    }
    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .client(getHttpClient())
            .build()
    }
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
    fun setTokenManager(tokenManager: TokenManager){
        this.tokenManager = tokenManager
    }
    fun getAuthApi(): AuthApi.AuthApi = retrofit.create(AuthApi.AuthApi::class.java)
    fun getMovieApi(): MovieApi = retrofit.create(MovieApi::class.java)
    fun getProfileApi(): ProfileApi = retrofit.create(ProfileApi::class.java)
    fun getFavoriteApi(): FavoriteApi = retrofit.create(FavoriteApi::class.java)

    companion object {
        private var instance: Network? = null

        fun getInstance(): Network{
            return instance ?: synchronized(this){
                instance ?: Network().also{ instance = it}
            }
        }

    }
    fun getTokenManager(): TokenManager {
        return this.tokenManager
    }
}

