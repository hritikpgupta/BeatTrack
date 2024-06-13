package com.hg.wear.app.presentation

import android.app.Application
import com.hg.core.connectivity.data.coreConnectivityDataModule
import com.hg.wear.app.presentation.di.appModule
import com.hg.wear.run.data.di.wearRunDataModule
import com.hg.wear.run.presentation.di.wearRunPresentationModule
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class BeatTrackApp : Application() {
    val applicationScope = CoroutineScope(SupervisorJob())

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@BeatTrackApp)
            modules(appModule,wearRunPresentationModule, wearRunDataModule, coreConnectivityDataModule)
        }
    }
}