package com.hg.auth.data.di

import com.hg.auth.data.AuthRepositoryImpl
import com.hg.auth.data.EmailPatternValidator
import com.hg.auth.domain.AuthRepository
import com.hg.auth.domain.PatternValidator
import com.hg.auth.domain.UserDataValidator
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import org.koin.dsl.bind


val authDataModule = module {
    single<PatternValidator> {
        EmailPatternValidator
    }
    singleOf(::UserDataValidator)
    singleOf(::AuthRepositoryImpl).bind<AuthRepository>()
}