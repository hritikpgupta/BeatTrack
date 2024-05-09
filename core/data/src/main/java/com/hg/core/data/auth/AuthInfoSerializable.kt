package com.hg.core.data.auth
@kotlinx.serialization.Serializable
data class AuthInfoSerializable(
    val accessToken:String,
    val refreshToken:String,
    val userId:String
)
