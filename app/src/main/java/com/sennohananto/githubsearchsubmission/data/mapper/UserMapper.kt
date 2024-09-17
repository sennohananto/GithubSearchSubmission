package com.sennohananto.githubsearchsubmission.data.mapper

import com.sennohananto.githubsearchsubmission.domain.model.User
import com.sennohananto.githubsearchsubmission.domain.model.UserEntity

fun UserEntity.toDomain(): User {
    return User(username, avatarUrl, id, url, name, bio)
}

fun User.toEntity(): UserEntity {
    return UserEntity(id, username, avatarUrl, bio, url, name)
}

//private fun User.toUser(): User {
//    return User(
//        username = login,
//        avatarUrl = avatar_url,
//        profileUrl = html_url,
//        bio = bio
//    )
//}