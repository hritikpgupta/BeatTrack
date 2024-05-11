package com.hg.auth.presentation.login

import com.hg.core.presentation.ui.UiText

sealed interface LoginEvent {
    data object LoginSuccess: LoginEvent
    data class Error(val error: UiText): LoginEvent
}