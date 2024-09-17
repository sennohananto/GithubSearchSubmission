package com.sennohananto.githubsearchsubmission.presentation.di

import android.content.Context
import androidx.room.Room
import com.sennohananto.githubsearchsubmission.data.api.GithubApi
import com.sennohananto.githubsearchsubmission.data.source.LocalDataSource
import com.sennohananto.githubsearchsubmission.data.source.RemoteDataSource
import com.sennohananto.githubsearchsubmission.data.repository.UserRepositoryImpl
import com.sennohananto.githubsearchsubmission.domain.usecase.GetUserDetailUseCase
import com.sennohananto.githubsearchsubmission.domain.usecase.SearchUserUseCase
import com.sennohananto.githubsearchsubmission.domain.repository.UserRepository
import com.sennohananto.githubsearchsubmission.data.source.room.AppDatabase
import com.sennohananto.githubsearchsubmission.data.source.room.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Provides
    @Singleton
    fun provideUserDatabase(context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "user_database"
        ).build()
    }

    @Provides
    @Singleton
    fun provideUserDao(userDatabase: AppDatabase): UserDao {
        return userDatabase.userDao()
    }

    @Provides
    @Singleton
    fun provideGitHubService(): GithubApi {
        return Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(GithubApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRemoteDataSource(githubApi: GithubApi): RemoteDataSource {
        return RemoteDataSource(githubApi)
    }

    @Provides
    @Singleton
    fun provideLocalDataSource(userDao: UserDao): LocalDataSource {
        return LocalDataSource(userDao)
    }

    @Provides
    @Singleton
    fun provideUserRepository(
        remoteDataSource: RemoteDataSource,
        localDataSource: LocalDataSource
    ): UserRepository {
        return UserRepositoryImpl(remoteDataSource, localDataSource)
    }

    // Provide Use Cases
    @Provides
    fun provideSearchUserUseCase(userRepository: UserRepository): SearchUserUseCase {
        return SearchUserUseCase(userRepository)
    }

    @Provides
    fun provideGetUserDetailUseCase(userRepository: UserRepository): GetUserDetailUseCase {
        return GetUserDetailUseCase(userRepository)
    }
}