package com.sennohananto.githubsearchsubmission.data.source

import com.sennohananto.githubsearchsubmission.domain.model.UserEntity
import com.sennohananto.githubsearchsubmission.data.source.room.UserDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalDataSource @Inject constructor(
    private val userDao: UserDao
) {

    /**
     * Inserts a list of users into the local database.
     *
     * @param users The list of users to insert.
     */
    suspend fun insertUsers(users: List<UserEntity>) {
        userDao.insertUsers(users)
    }

    /**
     * Retrieves a list of users from the local database.
     *
     * @return A Flow that emits a list of users.
     */
    fun getUsers(): Flow<List<UserEntity>> {
        return userDao.getAllUsers()
    }

    /**
     * Retrieves a single user by username from the local database.
     *
     * @param username The username of the user to retrieve.
     * @return A Flow that emits a User object, or null if not found.
     */
    fun getUser(username: String): Flow<UserEntity?> {
        return userDao.getUserByUsername(username)
    }
}