package com.example.pixabaychallenge

import android.app.Application
import androidx.compose.runtime.Composable
import androidx.room.Room
import coil.Coil
import coil.request.CachePolicy
import com.example.pixabaychallenge.R
import com.example.pixabaychallenge.database.ImageDatabase
import com.example.pixabaychallenge.network.api.PixabayApi
import com.example.pixabaychallenge.repositories.ImageRepositoryImpl
import com.example.pixabaychallenge.ui.components.SearchScreen
import com.example.pixabaychallenge.ui.viewmodels.ImageViewModel
import com.example.pixabaychallenge.util.Constants
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class PixabayApp() : Application() {
    override fun onCreate() {
        super.onCreate()
        Room.databaseBuilder(
            applicationContext,
            ImageDatabase::class.java,
            Constants.DB_NAME
        ).build()
    }
}
