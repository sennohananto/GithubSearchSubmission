package com.sennohananto.githubsearchsubmission.data.source.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.sennohananto.githubsearchsubmission.domain.model.UserEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    /**
     * Inserts a list of users into the local database. If a user already exists, it will be replaced.
     *
     * @param users The list of users to insert.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUsers(users: List<UserEntity>)

    /**
     * Retrieves all users from the local database.
     *
     * @return A Flow that emits a list of users.
     */
    @Query("SELECT * FROM users")
    fun getAllUsers(): Flow<List<UserEntity>>

    /**
     * Retrieves a single user by username from the local database.
     *
     * @param username The username of the user to retrieve.
     * @return A Flow that emits a User object, or null if the user does not exist.
     */
    @Query("SELECT * FROM users WHERE username = :username")
    fun getUserByUsername(username: String): Flow<UserEntity?>
}