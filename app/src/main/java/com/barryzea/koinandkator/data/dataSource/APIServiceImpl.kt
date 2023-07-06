package com.barryzea.koinandkator.data.dataSource

import android.annotation.SuppressLint
import android.content.Context
import com.barryzea.koinandkator.common.Constants
import com.barryzea.koinandkator.common.getUnsafeOkHttp
import com.barryzea.koinandkator.common.getUnsafeOkHttpClient
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.security.SecureRandom
import java.security.cert.X509Certificate
import javax.net.ssl.SSLContext
import javax.net.ssl.SSLSocketFactory
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager


/**
 * Project KoinAndKator
 * Created by Barry Zea H. on 6/07/23.
 * Copyright (c) Barry Zea H. All rights reserved.
 *
 **/
class APIServiceImpl:APIService {
//****************

    //*************
    private val retrofit = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .client(getUnsafeOkHttp()!!)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    override fun callApi():APIClient = retrofit.create(APIClient::class.java)
}