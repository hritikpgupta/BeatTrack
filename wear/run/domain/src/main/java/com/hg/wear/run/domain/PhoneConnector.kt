package com.hg.wear.run.domain

import com.hg.core.connectivity.domain.DeviceNode
import com.hg.core.connectivity.domain.messaging.MessagingAction
import com.hg.core.connectivity.domain.messaging.MessagingError
import com.hg.core.domain.util.EmptyResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

interface PhoneConnector {
    val connectedNode: StateFlow<DeviceNode?>

    val messagingActions: Flow<MessagingAction>

    suspend fun sendActionToPhone(action: MessagingAction) : EmptyResult<MessagingError>
}