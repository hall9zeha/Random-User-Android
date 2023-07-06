package com.barryzea.koinandkator.data.entities

import com.barryzea.koinandkator.domain.entities.UserDomain
import com.google.gson.annotations.SerializedName

/**
 * Project KoinAndKator
 * Created by Barry Zea H. on 6/07/23.
 * Copyright (c) Barry Zea H. All rights reserved.
 *
 **/

data class Results(@SerializedName("results")val results:List<RandomUser>)
data class RandomUser(
    @SerializedName("gender")val gender:String?= null,
    @SerializedName("name")val name: Name?= null,
    @SerializedName("location")val location: Location?=null,
    @SerializedName("email")val email:String?=null,
    @SerializedName("cell")val cell:String?=null,
    @SerializedName("picture")val picture: Picture?=null

)

data class Name(@SerializedName("title")val title:String?= null,
                @SerializedName("first")val first:String?=null,
                @SerializedName("last")val last:String?=null)

data class Location(@SerializedName("city")val city:String?=null,
                    @SerializedName("country")val country:String?=null)

data class Picture(@SerializedName("large")val large:String?=null,
                   @SerializedName("medium")val medium:String?=null,
                   @SerializedName("thumbnail")val thumbnail:String?=null)
fun Results.toDomain():List<UserDomain>{
    return results.map {
        UserDomain(name=it.name?.first,
            lastName = it.name?.last,
            cell=it.cell,
            email=it.email,
            city=it.location?.city,
            country=it.location?.country,
            image=it.picture?.large)
    }
}