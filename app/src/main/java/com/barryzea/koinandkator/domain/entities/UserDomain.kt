package com.barryzea.koinandkator.domain.entities

/**
 * Project KoinAndKator
 * Created by Barry Zea H. on 6/07/23.
 * Copyright (c) Barry Zea H. All rights reserved.
 *
 **/
data class UserDomain (val name:String?=null,
                       val lastName:String?=null,
                       val cell:String?=null,
                       val email:String?=null,
                       val city:String?=null,
                       val country:String?=null,
                       val image:String?=null)