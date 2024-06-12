package com.hg.wear.app.presentation

import android.app.Application
import com.hg.wear.run.presentation.di.runPresentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class BeatTrackApp : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@BeatTrackApp)
            modules(runPresentationModule)
        }
    }
}