package com.barryzea.koinandkator.domain.useCase

import com.barryzea.koinandkator.common.CustomResponse
import com.barryzea.koinandkator.data.entities.toDomain
import com.barryzea.koinandkator.data.repository.Repository

/**
 * Project KoinAndKator
 * Created by Barry Zea H. on 6/07/23.
 * Copyright (c) Barry Zea H. All rights reserved.
 *
 **/
class FetchUserUseCaseImpl(private val repository:Repository):FetchUserUseCase {
    override suspend fun fetchRandomUser(): CustomResponse {
       try {
           val response = repository.fetchRandomUser()
            if(response.isSuccessful){
                response.body()?.let{
                    return CustomResponse.ResponseSuccess(it.toDomain())
                }
            }

       }catch(e:Exception){
           return CustomResponse.ResponseError(e)
       }
        return CustomResponse.ResponseSuccess(emptyList())
    }
}