package com.example.data.model

enum class AuthProvider(val displayName: String) {
    GOOGLE("Google"),
    FACEBOOK("Facebook"),
    EMAIL("Email"),
    GUEST("Guest")
}

data class UserProfile(
    val id: String,
    val name: String,
    val email: String,
    val provider: AuthProvider,
    val photoUrl: String? = null,
    val grade: Int = 11,
    val signedInAt: Long = System.currentTimeMillis()
)
