package com.example.pixabaychallenge.repositories

import com.example.pixabaychallenge.models.Image

interface ImageRepository {
    suspend fun searchImages(query: String): List<Image>
    suspend fun getImageById(id: Int): Image?
}