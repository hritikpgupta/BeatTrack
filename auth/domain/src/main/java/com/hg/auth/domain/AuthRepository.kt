package com.hg.auth.domain

import com.hg.core.domain.util.DataError
import com.hg.core.domain.util.EmptyResult

interface AuthRepository {
    suspend fun register(email: String, password: String): EmptyResult<DataError.Network>
    suspend fun login(email: String, password: String): EmptyResult<DataError.Network>
}