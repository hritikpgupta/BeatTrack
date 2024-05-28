package com.hg.core.data.di

import com.hg.core.data.auth.EncryptedSessionStorage
import com.hg.core.data.networking.HttpClientFactory
import com.hg.core.domain.SessionStorage
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import com.hg.core.domain.run.RunRepository
import com.hg.core.data.run.OfflineFirstRunRepository

import org.koin.dsl.module

val coreDataModule = module {
    single {
        HttpClientFactory(get()).build()
    }
    singleOf(::EncryptedSessionStorage).bind<SessionStorage>()

    singleOf(::OfflineFirstRunRepository).bind<RunRepository>()

}