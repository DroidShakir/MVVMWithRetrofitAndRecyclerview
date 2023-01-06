package com.protocol.mvvmwithretrofitandrecyclerview

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.protocol.mvvmwithretrofitandrecyclerview.adapter.MainAdapter
import com.protocol.mvvmwithretrofitandrecyclerview.api.RetrofitService
import com.protocol.mvvmwithretrofitandrecyclerview.databinding.ActivityMainBinding
import com.protocol.mvvmwithretrofitandrecyclerview.repository.MainRepository
import com.protocol.mvvmwithretrofitandrecyclerview.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    private val tag = "MainActivity"
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private val retrofitService = RetrofitService.getInstance()
    private val adapter = MainAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //get view-model instance using MyViewModelFactory
        viewModel =
            ViewModelProvider(this, MyViewModelFactory(MainRepository(retrofitService))).get(
                MainViewModel::class.java
            )

        //set recyclerview adapter
        binding.recyclerview.adapter = adapter

        viewModel.movieList.observe(this) {
            Log.d(tag, "movieList: $it")
            adapter.setMovieList(it)
        }

        viewModel.errorMessage.observe(this) {
            Log.d(tag, "errorMessage: $it")
        }

        viewModel.getAllMovies()
    }
}