package com.example.pixabaychallenge.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ImageDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertImages(images: List<ImageEntity>)

    @Query("SELECT * FROM images WHERE id = :id")
    suspend fun getImageById(id: Int): ImageEntity?

    @Query("SELECT * FROM images WHERE tags LIKE '%' || :query || '%'")
    suspend fun searchImages(query: String): List<ImageEntity>
}