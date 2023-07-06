package com.barryzea.koinandkator.di

import com.barryzea.koinandkator.data.dataSource.APIService
import com.barryzea.koinandkator.data.dataSource.APIServiceImpl
import com.barryzea.koinandkator.data.repository.Repository
import com.barryzea.koinandkator.data.repository.RepositoryImpl
import com.barryzea.koinandkator.domain.useCase.FetchUserUseCase
import com.barryzea.koinandkator.domain.useCase.FetchUserUseCaseImpl
import com.barryzea.koinandkator.viewModel.ViewModelMain
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Project KoinAndKator
 * Created by Barry Zea H. on 6/07/23.
 * Copyright (c) Barry Zea H. All rights reserved.
 *
 **/
   val appModule= module {
        single<APIService> { APIServiceImpl() }
        single<Repository>{RepositoryImpl(get())}
        single<FetchUserUseCase>{FetchUserUseCaseImpl(get())}
        viewModel{ViewModelMain(get())}
    }
