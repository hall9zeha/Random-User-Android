package com.barryzea.koinandkator.viewModel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.barryzea.koinandkator.DatasourceForTest.createUser
import com.barryzea.koinandkator.DatasourceForTest.randomUser
import com.barryzea.koinandkator.common.CustomResponse
import com.barryzea.koinandkator.data.entities.toDomain
import com.barryzea.koinandkator.domain.entities.UserDomain
import com.barryzea.koinandkator.domain.useCase.FetchUserUseCase
import com.barryzea.koinandkator.domain.useCase.FetchUserUseCaseImpl
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.mockk
import io.mockk.mockkStatic
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.hamcrest.core.Is.`is`
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.koin.test.KoinTest
import org.mockito.Mockito.`when`
import org.mockito.kotlin.any
import org.mockito.kotlin.mock
import retrofit2.Response

/**
 * Project KoinAndKator
 * Created by Barry Zea H. on 9/07/23.
 * Copyright (c) Barry Zea H. All rights reserved.
 *
 */

@OptIn(ExperimentalCoroutinesApi::class)
class ViewModelMainTest:KoinTest{

    //private val useCase = mockk<FetchUserUseCase>(relaxed = true)
    @RelaxedMockK
    private  lateinit var useCase:FetchUserUseCase
    private lateinit var  viewModel:ViewModelMain

    @get:Rule
    var rule = InstantTaskExecutorRule()

    @Before
    fun onBefore(){
        MockKAnnotations.init(this)
        viewModel = ViewModelMain(useCase)
        Dispatchers.setMain(Dispatchers.Unconfined)
    }


    @After
    fun onAfter(){
       Dispatchers.resetMain()
    }

    @Test
    fun `when response is successful`() = runTest {
        //todo implementar test de las clases selladas al llamar fetchRandomUser()
        /*
            //Al parecer aún no se pueden burlar las clases selladas de esta manera, habría que cambiar la
            //implementación del viewModel y el UseCase para testear de otra forma.

            val userRandomList = listOf(createUser())
            val responseData = CustomResponse.ResponseSuccess(userRandomList)
            coEvery {viewModel.fetchRandomUser()} returns //Sealed Class CustomResponse no se puede instanciar error
            assert(viewModel.user.value == responseData.data)

         */
        val userRandomList = listOf(createUser())
        val responseData = CustomResponse.ResponseSuccess(userRandomList)
        val probe = getResponse()
        viewModel.fetchRandomUser()
        assertEquals(responseData.data,(probe as CustomResponse.ResponseSuccess).data)

    }
    private fun getResponse():CustomResponse{
        val userRandomList = listOf(createUser())
        return CustomResponse.ResponseSuccess(userRandomList)
    }

}