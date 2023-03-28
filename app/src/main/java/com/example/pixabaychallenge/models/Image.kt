package com.example.pixabaychallenge.models

data class Image(
    val id: Long,
    val previewUrl: String,
    val largeImageUrl: String,
    val user: String,
    val tags: List<String>,
    val likes: Int,
    val downloads: Int,
    val comments: Int
)
