package com.barryzea.koinandkator.common

import android.annotation.SuppressLint
import com.barryzea.koinandkator.data.entities.Results
import com.barryzea.koinandkator.domain.entities.UserDomain
import okhttp3.OkHttpClient
import retrofit2.Response
import java.security.SecureRandom
import java.security.cert.CertificateException
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
fun getUnsafeOkHttpClient(): OkHttpClient.Builder {
    //Ya que accederemos sin una llave/API KEY
    //esta función nos ayudará para acceder a la URL con certificado Https Autofirmado de la API Random User
    //así como para la obtención de las imágenes con Glide
    return try {
        // Create a trust manager that does not validate certificate chains
        val trustAllCerts = arrayOf<TrustManager>(
            object : X509TrustManager {
                @SuppressLint("TrustAllX509TrustManager")
                override fun checkClientTrusted(
                    chain: Array<X509Certificate>,
                    authType: String
                ) {
                }

                @SuppressLint("TrustAllX509TrustManager")
                override fun checkServerTrusted(
                    chain: Array<X509Certificate>,
                    authType: String
                ) {
                }

                override fun getAcceptedIssuers(): Array<X509Certificate> {
                    return arrayOf()
                }
            }
        )

        // Install the all-trusting trust manager
        val sslContext = SSLContext.getInstance("SSL")
        sslContext.init(null, trustAllCerts, SecureRandom())

        // Create an ssl socket factory with our all-trusting manager
        val sslSocketFactory: SSLSocketFactory = sslContext.socketFactory
        val builder = OkHttpClient.Builder()
        builder.sslSocketFactory(sslSocketFactory, trustAllCerts[0] as X509TrustManager)
        builder

    } catch (e: Exception) {
        throw RuntimeException(e)
    }


}
sealed class CustomResponse{
    class ResponseSuccess(val data: List<UserDomain>) : CustomResponse()
    class ResponseError(val error:Exception):CustomResponse()
}
