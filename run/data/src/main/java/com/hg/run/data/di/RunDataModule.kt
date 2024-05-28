package com.hg.run.data.di

import com.hg.core.domain.run.SyncRunScheduler
import com.hg.run.data.CreateRunWorker
import com.hg.run.data.DeleteRunWorker
import com.hg.run.data.FetchRunsWorker
import com.hg.run.data.SyncRunWorkerScheduler
import org.koin.androidx.workmanager.dsl.workerOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val runDataModule = module {
    workerOf(::CreateRunWorker)
    workerOf(::FetchRunsWorker)
    workerOf(::DeleteRunWorker)

    singleOf(::SyncRunWorkerScheduler).bind<SyncRunScheduler>()

}