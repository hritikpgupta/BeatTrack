package com.hg.auth.data

import com.hg.auth.domain.AuthRepository
import com.hg.core.data.networking.post
import com.hg.core.domain.util.DataError
import com.hg.core.domain.util.EmptyResult
import io.ktor.client.HttpClient

class AuthRepositoryImpl(
    private val httpClient: HttpClient
) : AuthRepository {
    override suspend fun register(email: String, password: String): EmptyResult<DataError.Network> {
        return httpClient.post<RegisterRequest,Unit>(
            route = "/register", body = RegisterRequest(email, password)
        )
    }
}