package com.barryzea.koinandkator.data.dataSource

import com.barryzea.koinandkator.data.entities.Results
import retrofit2.Response
import retrofit2.http.GET


/**
 * Project KoinAndKator
 * Created by Barry Zea H. on 6/07/23.
 * Copyright (c) Barry Zea H. All rights reserved.
 *
 **/
interface APIClient {
    @GET("api")
    suspend fun fetchRandomUser(): Response<Results>
}