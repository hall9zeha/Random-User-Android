package com.barryzea.koinandkator.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.barryzea.koinandkator.data.entities.RandomUser
import com.barryzea.koinandkator.domain.entities.UserDomain
import com.barryzea.koinandkator.domain.useCase.FetchUserUseCase
import kotlinx.coroutines.launch

/**
 * Project KoinAndKator
 * Created by Barry Zea H. on 6/07/23.
 * Copyright (c) Barry Zea H. All rights reserved.
 *
 **/
class ViewModelMain(private val useCase:FetchUserUseCase): ViewModel() {
    private var _user:MutableLiveData<UserDomain> = MutableLiveData()
    val user:LiveData<UserDomain> get() = _user
    private var _isLoading:MutableLiveData<Boolean> = MutableLiveData(true)
    val isLoading:LiveData<Boolean> get() = _isLoading

    fun fetchRandomUser(){
        _isLoading.postValue(true)
        viewModelScope.launch {
            val randomList = useCase.fetchRandomUser()
           if(randomList.isNotEmpty()){
               _isLoading.postValue(false)
               _user.postValue(randomList[0])

           }
        }
    }

}