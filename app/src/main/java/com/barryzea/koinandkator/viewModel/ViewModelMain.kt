package com.barryzea.koinandkator.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.barryzea.koinandkator.common.CustomResponse
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
    private var _msg:MutableLiveData<String> = MutableLiveData()
    val msg:LiveData<String> get() = _msg

   fun fetchRandomUser(){
        _isLoading.postValue(true)
        viewModelScope.launch {
            val response = useCase.fetchRandomUser()
            when (response) {
                is CustomResponse.ResponseSuccess -> {
                    _isLoading.postValue(false)
                    _user.postValue(response.data[0])
                }
                is CustomResponse.ResponseError -> {
                    _isLoading.postValue(false)
                    _msg.postValue(response.error.message.toString())
                }
            }
        }
    }

}