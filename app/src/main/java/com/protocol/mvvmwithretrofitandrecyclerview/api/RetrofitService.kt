package com.protocol.mvvmwithretrofitandrecyclerview.api

import com.protocol.mvvmwithretrofitandrecyclerview.model.Movie
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


interface RetrofitService {
    @GET("movielist.json")
    fun getAllMovies(): Call<List<Movie>>

    companion object {
        private var retrofitService: RetrofitService? = null

        //Creating the Retrofit service instance using the retrofit
        fun getInstance(): RetrofitService {
            if (retrofitService == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl("https://www.howtodoandroid.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofitService = retrofit.create(RetrofitService::class.java)
            }
            return retrofitService!!
        }
    }
}