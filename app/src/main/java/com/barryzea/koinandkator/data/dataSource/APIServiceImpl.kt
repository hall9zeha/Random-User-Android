package com.barryzea.koinandkator.data.dataSource

import com.barryzea.koinandkator.common.Constants
import com.barryzea.koinandkator.common.getUnsafeOkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/**
 * Project KoinAndKator
 * Created by Barry Zea H. on 6/07/23.
 * Copyright (c) Barry Zea H. All rights reserved.
 *
 **/
class APIServiceImpl:APIService {
    private val retrofit = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .client(getUnsafeOkHttpClient().build())
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    override fun callApi():APIClient = retrofit.create(APIClient::class.java)
}