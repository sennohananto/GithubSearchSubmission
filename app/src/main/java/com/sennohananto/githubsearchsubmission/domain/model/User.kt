package com.sennohananto.githubsearchsubmission.domain.model

import com.squareup.moshi.Json

data class User(
    @Json(name = "login") val username: String,
    @Json(name = "avatar_url") val avatarUrl: String,
    @Json(name = "id") val id: Int,
    @Json(name = "url") val url: String,
    @Json(name = "name") val name: String?,
    @Json(name = "bio") val bio: String?
)