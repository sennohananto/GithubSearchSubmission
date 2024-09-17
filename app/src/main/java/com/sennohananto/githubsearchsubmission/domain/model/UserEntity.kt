package com.sennohananto.githubsearchsubmission.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class UserEntity(
    @PrimaryKey val id: Int,
    val username: String,
    val avatarUrl: String,
    val bio: String?,
    val url: String,
    val name: String?,
)