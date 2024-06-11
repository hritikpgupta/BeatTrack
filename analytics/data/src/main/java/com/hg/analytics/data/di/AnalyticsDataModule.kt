package com.hg.analytics.data.di

import com.hg.analytics.data.RoomAnalyticsRepository
import com.hg.analytics.domain.AnalyticsRepository
import com.hg.core.database.RunDatabase
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val analyticsModule = module {
    singleOf(::RoomAnalyticsRepository).bind<AnalyticsRepository>()
    single {
        get<RunDatabase>().analyticsDao
    }
}