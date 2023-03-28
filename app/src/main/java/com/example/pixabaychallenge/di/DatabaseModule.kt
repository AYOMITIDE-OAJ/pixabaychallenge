package com.example.pixabaychallenge.di

import android.app.Application
import androidx.room.Room
import com.example.pixabaychallenge.database.ImageDao
import com.example.pixabaychallenge.database.ImageDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
     fun provideImageDatabase(application: Application): ImageDatabase {
        return Room.databaseBuilder(
            application.applicationContext,
            ImageDatabase::class.java,
            "image_database"
        ).build()
    }

    @Provides
    fun provideImageDao(imageDatabase: ImageDatabase): ImageDao {
        return imageDatabase.imageDao()
    }

}