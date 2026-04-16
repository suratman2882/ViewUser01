package com.example.viewuser01.network

import com.example.viewuser01.model.User
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

// Interface endpoint API
interface UserApiService {
    @GET("users")
    suspend fun getUsers(): List<User>
}

// Singleton Retrofit
    private const val BASE_URL = "https://jsonplaceholder.typicode.com/"

    val api: UserApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(UserApiService::class.java)
    }