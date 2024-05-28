package com.hg.run.presentation.run_overview

import com.hg.run.presentation.run_overview.model.RunUi

data class RunOverviewState(
    val runs: List<RunUi> = emptyList()
)
