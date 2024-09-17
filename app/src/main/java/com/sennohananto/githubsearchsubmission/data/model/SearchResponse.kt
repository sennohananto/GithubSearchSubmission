package com.sennohananto.githubsearchsubmission.data.model

import com.sennohananto.githubsearchsubmission.domain.model.User
import com.squareup.moshi.Json

data class SearchResponse(
    @Json(name = "items") val users: List<User>
)