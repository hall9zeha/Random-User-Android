package com.barryzea.koinandkator

import com.barryzea.koinandkator.data.entities.Location
import com.barryzea.koinandkator.data.entities.Name
import com.barryzea.koinandkator.data.entities.Picture
import com.barryzea.koinandkator.data.entities.RandomUser
import com.barryzea.koinandkator.data.entities.Results
import com.barryzea.koinandkator.domain.entities.UserDomain

/**
 * Project KoinAndKator
 * Created by Barry Zea H. on 9/07/23.
 * Copyright (c) Barry Zea H. All rights reserved.
 *
 **/
object DatasourceForTest {

        fun createUser()= UserDomain(
            name="Barry",
            lastName="Zea",
            cell="569874565",
            email="myMail@mail.com",
            city = "Citadel",
            country="Laedale"

        )
        fun randomUser()= Results(listOf(
            RandomUser(
                gender="Male",
                name= Name("","Barry","Zea"),
                location = Location("",""),
                email = "mail@mail.com",
                cell="454654654",
                picture= Picture("","","jpg")
            )
        ))

}