package com.example.pixabaychallenge.di

import com.example.pixabaychallenge.database.ImageDao
import com.example.pixabaychallenge.network.api.PixabayApi
import com.example.pixabaychallenge.repositories.ImageRepository
import com.example.pixabaychallenge.repositories.ImageRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    fun provideImageRepository(
        pixabayApi: PixabayApi,
        imageDao: ImageDao
    ): ImageRepository{
        return ImageRepositoryImpl(pixabayApi, imageDao)
    }
}