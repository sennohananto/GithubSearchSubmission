package com.sennohananto.githubsearchsubmission.domain.usecase

import com.sennohananto.githubsearchsubmission.domain.repository.UserRepository
import com.sennohananto.githubsearchsubmission.domain.model.User
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class SearchUserUseCase @Inject constructor(
    private val userRepository: UserRepository
) {

    /**
     * Searches for users based on the query string.
     *
     * @param query The search query string.
     * @return A Flow that emits a list of User objects.
     */
    fun execute(query: String): Flow<List<User>> {
        return userRepository.getUsers(query)
    }
}