package com.hg.auth.data

import com.hg.auth.domain.AuthRepository
import com.hg.core.data.networking.post
import com.hg.core.domain.AuthInfo
import com.hg.core.domain.SessionStorage
import com.hg.core.domain.util.DataError
import com.hg.core.domain.util.EmptyResult
import com.hg.core.domain.util.Result
import com.hg.core.domain.util.asEmptyDataResult
import io.ktor.client.HttpClient

class AuthRepositoryImpl(
    private val httpClient: HttpClient,
    private val sessionStorage: SessionStorage
) : AuthRepository {
    override suspend fun register(email: String, password: String): EmptyResult<DataError.Network> {
        return httpClient.post<RegisterRequest, Unit>(
            route = "/register", body = RegisterRequest(email, password)
        )
    }

    override suspend fun login(email: String, password: String): EmptyResult<DataError.Network> {
        val result = httpClient.post<LoginRequest, LoginResponse>(
            route = "/login", body = LoginRequest(email, password)
        )

        if(result is Result.Success) {
            sessionStorage.set(
                AuthInfo(
                    accessToken = result.data.accessToken,
                    refreshToken = result.data.refreshToken,
                    userId = result.data.userId
                )
            )
        }
        return result.asEmptyDataResult()

    }
}