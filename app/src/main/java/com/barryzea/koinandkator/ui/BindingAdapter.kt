package com.barryzea.koinandkator.ui

import android.graphics.drawable.Drawable
import android.net.Uri
import android.util.Log
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import com.barryzea.koinandkator.R
import com.barryzea.koinandkator.common.AppGlide
import com.barryzea.koinandkator.common.GlideApp
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target


/**
 * Project KoinAndKator
 * Created by Barry Zea H. on 6/07/23.
 * Copyright (c) Barry Zea H. All rights reserved.
 *
 **/
@BindingAdapter("imageUrl")
fun setImage(imageView:ImageView, url:String?){


    url?.let {
        val imgUri = it.toUri().buildUpon().scheme("https").build()
        GlideApp.with(imageView.context)
            .load(imgUri)
            .placeholder(R.drawable.ic_launcher_background)
            .listener(object: RequestListener<Drawable>{
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: Target<Drawable>?,
                    isFirstResource: Boolean
                ): Boolean {
                    Log.e("GLIDE_LOG", e?.message.toString() )
                    return false
                }

                override fun onResourceReady(
                    resource: Drawable?,
                    model: Any?,
                    target: Target<Drawable>?,
                    dataSource: DataSource?,
                    isFirstResource: Boolean
                ): Boolean {
                   return false
                }
            })
            .centerCrop()

            .error(R.drawable.ic_launcher_foreground)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(imageView)
    }
}