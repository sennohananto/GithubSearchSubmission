package com.sennohananto.githubsearchsubmission.data.repository

import com.sennohananto.githubsearchsubmission.data.mapper.toDomain
import com.sennohananto.githubsearchsubmission.data.mapper.toEntity
import com.sennohananto.githubsearchsubmission.data.source.LocalDataSource
import com.sennohananto.githubsearchsubmission.data.source.RemoteDataSource
import com.sennohananto.githubsearchsubmission.domain.model.User
import com.sennohananto.githubsearchsubmission.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) : UserRepository {

    override fun getUsers(query: String): Flow<List<User>> = flow {
        try {
            // Fetch data from the remote source
            val response = remoteDataSource.searchUsers(query)
            val users = response.users
            // Save users to the local database
            localDataSource.insertUsers(users.map { it.toEntity() })
            emit(users) // Emit the list of users
        } catch (e: Exception) {
            // Handle exception, possibly network issues
            // Emit cached users from the local database if available
            localDataSource.getUsers().collect { cachedUsers ->
                emit(cachedUsers.map { it.toDomain() })
            }
        }
    }

    override fun getUser(username: String): Flow<User?> = localDataSource.getUser(username).map { it?.toDomain() }

//    private fun com.example.githubapp.data.remote.model.UserResponse.toUser(): User {
//        return User(
//            username = login,
//            avatarUrl = avatar_url,
//            profileUrl = html_url,
//            bio = bio
//        )
//    }
}