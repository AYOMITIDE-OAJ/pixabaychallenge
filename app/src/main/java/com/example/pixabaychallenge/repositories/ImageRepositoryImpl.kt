package com.example.pixabaychallenge.repositories

import com.example.pixabaychallenge.database.ImageDao
import com.example.pixabaychallenge.database.ImageEntity
import com.example.pixabaychallenge.models.Image
import com.example.pixabaychallenge.network.api.PixabayApi
import com.example.pixabaychallenge.util.Constants

class ImageRepositoryImpl(
    private val api: PixabayApi,
    private val dao: ImageDao
) : ImageRepository {
    override suspend fun searchImages(query: String): List<Image> {
        val cachedImages = dao.searchImages(query)
            .map { it.toImage() }

        if (cachedImages.isNotEmpty()) {
            return cachedImages
        }

        val response = api.searchImages(Constants.API_KEY, query)
        val images = response.hits.map { it.toEntity() }

        dao.insertImages(images)

        return images.map { it.toImage() }
    }

    override suspend fun getImageById(id: Int): Image? {
        TODO("Not yet implemented")
        val cachedImage = dao.getImageById(id)
        return cachedImage?.toImage()
    }
}
    private fun ImageEntity.toImage(): Image {
        return Image(
            id = id,
            previewUrl = previewUrl,
            largeImageUrl = largeImageUrl,
            user = user,
            tags = tags.split(','),
            likes = likes,
            downloads = downloads,
            comments = comments
        )
    }

    private fun Image.toEntity(): ImageEntity {
        return ImageEntity(
            id = id,
            previewUrl = previewUrl,
            largeImageUrl = largeImageUrl,
            user = user,
            tags = tags.joinToString(separator = ","),
            likes = likes,
            downloads = downloads,
            comments = comments
        )
    }
