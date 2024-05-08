package com.hg.beattrack

import android.app.Application
import com.hg.auth.data.di.authDataModule
import com.hg.auth.presentation.di.authViewModelModule
import com.hg.beattrack.di.appModule
import com.hg.core.data.di.coreDataModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import timber.log.Timber

class BeatTrackApp : Application() {

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            //8Um96FSuODb5BJw7
            Timber.plant(Timber.DebugTree())
        }

        startKoin {
            androidLogger()
            androidContext(this@BeatTrackApp)
            modules(authDataModule, authViewModelModule, appModule, coreDataModule)
        }
    }
}