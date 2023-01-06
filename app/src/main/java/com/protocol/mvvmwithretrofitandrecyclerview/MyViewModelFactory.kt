package com.protocol.mvvmwithretrofitandrecyclerview

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.protocol.mvvmwithretrofitandrecyclerview.repository.MainRepository
import com.protocol.mvvmwithretrofitandrecyclerview.viewmodel.MainViewModel

class MyViewModelFactory constructor(
    private val repository: MainRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            MainViewModel(this.repository) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}