package com.sennohananto.githubsearchsubmission.data.source.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sennohananto.githubsearchsubmission.domain.model.UserEntity

@Database(entities = [UserEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}