package com.hg.beattrack

import android.app.Application
import android.content.Context
import com.hg.auth.data.di.authDataModule
import com.hg.auth.presentation.di.authViewModelModule
import com.hg.beattrack.di.appModule
import com.hg.core.data.di.coreDataModule
import com.hg.core.database.di.databaseModule
import com.hg.run.data.di.runDataModule
import com.hg.run.location.di.locationModule
import com.hg.run.network.di.networkModule
import com.hg.run.presentation.di.runPresentationModule
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import timber.log.Timber
import androidx.work.Configuration
import androidx.work.WorkManager
import com.google.android.play.core.splitcompat.SplitCompat
import com.hg.core.connectivity.data.di.coreConnectivityDataModule
import org.koin.androidx.workmanager.koin.workManagerFactory


class BeatTrackApp() : Application() {
    val applicationScope = CoroutineScope(SupervisorJob())
    
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            //8Um96FSuODb5BJw7
            Timber.plant(Timber.DebugTree())
        }

        startKoin {
            androidLogger()
            androidContext(this@BeatTrackApp)
            workManagerFactory()
            modules(
                authDataModule,
                authViewModelModule,
                appModule,
                coreDataModule,
                runPresentationModule,
                locationModule,
                databaseModule,
                networkModule,
                runDataModule,
                coreConnectivityDataModule
            )
        }
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        SplitCompat.install(this)
    }
}