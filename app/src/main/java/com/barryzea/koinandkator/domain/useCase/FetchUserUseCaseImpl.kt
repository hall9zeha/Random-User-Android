package com.barryzea.koinandkator.domain.useCase

import com.barryzea.koinandkator.data.repository.Repository
import com.barryzea.koinandkator.data.entities.RandomUser
import com.barryzea.koinandkator.data.entities.toDomain
import com.barryzea.koinandkator.domain.entities.UserDomain

/**
 * Project KoinAndKator
 * Created by Barry Zea H. on 6/07/23.
 * Copyright (c) Barry Zea H. All rights reserved.
 *
 **/
class FetchUserUseCaseImpl(private val repository:Repository):FetchUserUseCase {
    override suspend fun fetchRandomUser(): List<UserDomain> {
        val response = repository.fetchRandomUser()
        if(response.isSuccessful){
            response.body()?.let{
               return it.toDomain()
            }
        }
        return emptyList()
    }
}