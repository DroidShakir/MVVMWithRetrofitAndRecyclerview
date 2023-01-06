package com.protocol.mvvmwithretrofitandrecyclerview.repository

import com.protocol.mvvmwithretrofitandrecyclerview.api.RetrofitService

class MainRepository constructor(
    private val retrofitService: RetrofitService
) {
    fun getAllMovies() = retrofitService.getAllMovies()
}