package com.example.jetpack.di

import android.content.Context
import android.util.Log
import com.example.jetpack.room.AppDatabase
import com.example.jetpack.room.CommentDao
import com.example.jetpack.room.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton


@InstallIn(ApplicationComponent::class)
@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase{
        Log.i("DatabaseModule", "provideAppDatabase: 我创建了")
        return AppDatabase.getInstance(context)
    }

    @Provides
    fun provideUserDao(appDatabase: AppDatabase): UserDao {
        return appDatabase.userDao()
    }

    @Provides
    fun provideGardenPlantingDao(appDatabase: AppDatabase): CommentDao {
        return appDatabase.commentDao()
    }

}