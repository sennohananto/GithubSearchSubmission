package com.sennohananto.githubsearchsubmission.data.source

import com.sennohananto.githubsearchsubmission.data.model.SearchResponse
import com.sennohananto.githubsearchsubmission.data.api.GithubApi
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val gitHubService: GithubApi
) {

    /**
     * Fetches a list of GitHub users based on the search query.
     *
     * @param query The search query string.
     * @return A [SearchResponse] containing a list of [UserResponse] objects.
     */
    suspend fun searchUsers(query: String): SearchResponse {
        val response = gitHubService.searchUsers(query)
        if (response.isSuccessful) {
            return response.body() ?: SearchResponse(emptyList())
        } else {
            // Handle API error here
            throw Exception("Error fetching users from API")
        }
    }
}