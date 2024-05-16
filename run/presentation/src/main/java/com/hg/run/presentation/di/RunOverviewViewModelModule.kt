package com.hg.run.presentation.di


import com.hg.run.presentation.active_run.ActiveRunViewModel
import com.hg.run.presentation.run_overview.RunOverviewViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module
import org.koin.core.module.dsl.singleOf
import com.hg.run.domain.RunningTracker


val runPresentationModule = module {
    singleOf(::RunningTracker)
    viewModelOf(::RunOverviewViewModel)
    viewModelOf(::ActiveRunViewModel)
}