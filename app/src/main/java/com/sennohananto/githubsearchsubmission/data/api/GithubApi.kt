package com.sennohananto.githubsearchsubmission.data.api

import com.sennohananto.githubsearchsubmission.data.model.SearchResponse
import com.sennohananto.githubsearchsubmission.domain.model.User
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GithubApi {
    @GET("search/users")
    suspend fun searchUsers(
        @Query("q") query: String
    ): Response<SearchResponse>

    @GET("users/{username}")
    suspend fun getUserDetail(@Path("username") username: String): Response<User>
}