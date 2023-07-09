package com.barryzea.koinandkator.domain.useCase


import com.barryzea.koinandkator.common.CustomResponse
import com.barryzea.koinandkator.data.entities.Location
import com.barryzea.koinandkator.data.entities.Name
import com.barryzea.koinandkator.data.entities.Picture
import com.barryzea.koinandkator.data.entities.RandomUser
import com.barryzea.koinandkator.data.entities.Results
import com.barryzea.koinandkator.data.entities.toDomain
import com.barryzea.koinandkator.data.repository.Repository
import com.barryzea.koinandkator.domain.entities.UserDomain
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.koin.test.KoinTest
import retrofit2.Response

/**
 * Project KoinAndKator
 * Created by Barry Zea H. on 8/07/23.
 * Copyright (c) Barry Zea H. All rights reserved.
 *
 */

class FetchUserUseCaseImplTest:KoinTest {

    private val repo = mockk<Repository>(relaxed=true)
    private val useCase = FetchUserUseCaseImpl(repo)

    @Before
    fun onBefore(){
        MockKAnnotations.init(this)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
   fun fetchRandomUserSuccessful() = runTest {
        val response = Response.success(randomUser())

        coEvery { repo.fetchRandomUser()} returns response

        val customResponse = useCase.fetchRandomUser()

        val responseSuccess = customResponse as CustomResponse.ResponseSuccess
        assert(responseSuccess.data == response.body()!!.toDomain())

    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun whenResponseIsAException() = runTest{
        val anyException = Exception()
        coEvery { repo.fetchRandomUser()}.throws(anyException)

        val customResponse = useCase.fetchRandomUser()
        val responseError = customResponse as CustomResponse.ResponseError

        assertEquals(anyException,responseError.error)
    }

    companion object{
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
}
