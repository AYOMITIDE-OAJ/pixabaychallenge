package com.example.pixabaychallenge.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "images")
data class ImageEntity (
    @PrimaryKey val id: Long,
    val previewUrl: String,
    val largeImageUrl: String,
    val user: String,
    val tags: String,
    val likes: Int,
    val downloads: Int,
    val comments: Int
)