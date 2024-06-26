package com.hg.wear.run.presentation

import com.hg.core.presentation.ui.UiText

sealed interface TrackerEvent {
    data object RunFinished : TrackerEvent

    data class Error(val message: UiText) : TrackerEvent
}