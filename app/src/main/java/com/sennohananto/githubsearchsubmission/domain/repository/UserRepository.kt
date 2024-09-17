package com.sennohananto.githubsearchsubmission.domain.repository

import com.sennohananto.githubsearchsubmission.domain.model.User
import kotlinx.coroutines.flow.Flow


interface UserRepository {

    /**
     * Fetches a list of users based on the search query.
     *
     * @param query The search query string.
     * @return A Flow that emits lists of User objects.
     */
    fun getUsers(query: String): Flow<List<User>>

    /**
     * Fetches a single user by username.
     *
     * @param username The username of the user to fetch.
     * @return A Flow that emits a User object, or null if the user does not exist.
     */
    fun getUser(username: String): Flow<User?>
}