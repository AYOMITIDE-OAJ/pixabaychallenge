package com.example.pixabaychallenge.di

import android.app.Application
import androidx.room.Room
import com.example.pixabaychallenge.database.ImageDao
import com.example.pixabaychallenge.database.ImageDatabase
import com.example.pixabaychallenge.network.api.PixabayApi
import com.example.pixabaychallenge.repositories.ImageRepository
import com.example.pixabaychallenge.repositories.ImageRepositoryImpl
import com.example.pixabaychallenge.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    fun providePixabayApi(): PixabayApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(PixabayApi::class.java)
    }

    @Provides
    fun provideImageDatabase(application: Application): ImageDatabase {
        return Room.databaseBuilder(
            application.applicationContext,
            ImageDatabase::class.java,
            Constants.DB_NAME
        ).build()
    }

    @Provides
    fun provideImageDao(imageDatabase: ImageDatabase): ImageDao {
        return imageDatabase.imageDao()
    }

    @Provides
    fun provideImageRepository(
        api: PixabayApi,
        dao: ImageDao
    ): ImageRepository {
        return ImageRepositoryImpl(api, dao)
    }
}