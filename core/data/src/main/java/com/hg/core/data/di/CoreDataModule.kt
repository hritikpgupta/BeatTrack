package com.hg.core.data.di

import com.hg.core.data.auth.EncryptedSessionStorage
import com.hg.core.data.networking.HttpClientFactory
import com.hg.core.domain.SessionStorage
import org.koin.dsl.module

val coreDataModule = module {
    single {
        HttpClientFactory().build()
    }
    singleOf(::EncryptedSessionStorage).bind<SessionStorage>()
}