package com.hg.wear.run.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hg.wear.run.domain.ExerciseTracker
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class TrackerViewModel(
    private val exerciseTracker: ExerciseTracker
) : ViewModel() {

    var state by mutableStateOf(TrackerState(
        isConnectedPhoneNearby = true
    ))
        private set

    private val hasBodySensorPermission = MutableStateFlow(false)

    init {
        viewModelScope.launch {
            hasBodySensorPermission.flatMapLatest { isGranted ->
                if (isGranted) {
                    exerciseTracker.heartRate
                } else flowOf()
            }.onEach {
                state = state.copy(
                    heartRate = it
                )
            }.launchIn(this)
        }
    }

    fun onAction(action: TrackerAction) {
        when (action) {
            is TrackerAction.OnBodySensorPermissionResult -> {
                hasBodySensorPermission.value = action.isGranted
                if (action.isGranted) {
                    viewModelScope.launch {
                        val isHeartRateTrackingSupported =
                            exerciseTracker.isHeartRateTrackingSupported()
                        state = state.copy(
                            canTrackHeartRate = isHeartRateTrackingSupported
                        )
                        exerciseTracker.prepareExercise()
                        exerciseTracker.startExercise()
                    }
                }
            }

            TrackerAction.OnFinishRunClick -> Unit
            TrackerAction.OnToggleRunClick -> Unit
        }
    }
}