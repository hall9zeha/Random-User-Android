package com.barryzea.koinandkator.data.repository

import com.barryzea.koinandkator.data.dataSource.APIService
import com.barryzea.koinandkator.data.entities.Results
import retrofit2.Response

/**
 * Project KoinAndKator
 * Created by Barry Zea H. on 6/07/23.
 * Copyright (c) Barry Zea H. All rights reserved.
 *
 **/
class RepositoryImpl(private val apiService:APIService):Repository {
    override suspend fun fetchRandomUser(): Response<Results> {
        return apiService.callApi().fetchRandomUser()
    }
}