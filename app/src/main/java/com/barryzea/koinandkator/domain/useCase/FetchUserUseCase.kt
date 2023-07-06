package com.barryzea.koinandkator.domain.useCase

import com.barryzea.koinandkator.data.entities.RandomUser
import com.barryzea.koinandkator.domain.entities.UserDomain

/**
 * Project KoinAndKator
 * Created by Barry Zea H. on 6/07/23.
 * Copyright (c) Barry Zea H. All rights reserved.
 *
 **/
interface FetchUserUseCase {
    suspend fun fetchRandomUser():List<UserDomain>
}