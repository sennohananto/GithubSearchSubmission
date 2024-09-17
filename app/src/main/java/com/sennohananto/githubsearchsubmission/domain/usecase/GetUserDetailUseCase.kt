package com.sennohananto.githubsearchsubmission.domain.usecase

import com.sennohananto.githubsearchsubmission.domain.repository.UserRepository
import com.sennohananto.githubsearchsubmission.domain.model.User
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class GetUserDetailUseCase @Inject constructor(
    private val userRepository: UserRepository
) {

    /**
     * Retrieves detailed information about a user by username.
     *
     * @param username The username of the user to fetch.
     * @return A Flow that emits the User object, or null if not found.
     */
    fun execute(username: String): Flow<User?> {
        return userRepository.getUser(username)
    }
}