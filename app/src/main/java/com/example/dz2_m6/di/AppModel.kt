package com.example.dz2_m6.di

import android.content.Context
import androidx.room.Room
import com.example.dz2_m6.data.local.AppDatabase
import com.example.dz2_m6.data.local.TaskDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class AppModel {
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, "task_list")
            .allowMainThreadQueries().build()
    }

    @Provides
    fun dao(@ApplicationContext context: Context): TaskDao {
        return provideDatabase(context).dao()
    }
}