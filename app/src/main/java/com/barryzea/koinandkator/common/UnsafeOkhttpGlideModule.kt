package com.barryzea.koinandkator.common

import android.content.Context
import com.bumptech.glide.Glide
import com.bumptech.glide.Registry
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.integration.okhttp3.OkHttpUrlLoader
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.module.AppGlideModule
import com.bumptech.glide.module.LibraryGlideModule
import java.io.InputStream


/**
 * Project KoinAndKator
 * Created by Barry Zea H. on 6/07/23.
 * Copyright (c) Barry Zea H. All rights reserved.
 *
 **/


@GlideModule
class AppGlide: AppGlideModule() {
    override fun registerComponents(context: Context, glide: Glide, registry: Registry) {
      /*
      * Este módulo personalizado de Glide es necesario para poder leer las imágenes desde las url devueltas
      * desde la API(si no nos dará un error al tratar de obtener la imagen del path), ya que nos permite aceptar el certificado autofirmado HTTPS de la API con la función getUnsafeOkHttpClient()
      * */
        registry.replace(
            GlideUrl::class.java, InputStream::class.java,
            OkHttpUrlLoader.Factory(getUnsafeOkHttpClient().build())
        )
    }
}