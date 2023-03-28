package com.example.pixabaychallenge.network.api

import com.example.pixabaychallenge.models.SearchResponse
import com.example.pixabaychallenge.util.Constants
import retrofit2.http.GET
import retrofit2.http.Query

interface PixabayApi {
    @GET("?key=${Constants.API_KEY}&image_type=photo&per_page=50")
    suspend fun searchImages(
        @Query("key") apiKey: String,
        @Query("q") query: String
    ): SearchResponse

}