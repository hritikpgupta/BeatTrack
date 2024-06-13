package com.hg.wear.app.presentation.di

import com.hg.wear.app.presentation.BeatTrackApp
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val appModule = module {
    single {
        (androidApplication() as BeatTrackApp).applicationScope
    }
}