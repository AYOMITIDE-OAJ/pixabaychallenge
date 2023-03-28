package com.example.pixabaychallenge.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.ViewModelProvider
import com.example.pixabaychallenge.database.ImageDao
import com.example.pixabaychallenge.database.ImageEntity
import com.example.pixabaychallenge.models.Image
import com.example.pixabaychallenge.models.SearchResponse
import com.example.pixabaychallenge.network.api.PixabayApi
import com.example.pixabaychallenge.repositories.ImageRepository
import com.example.pixabaychallenge.repositories.ImageRepositoryImpl
import com.example.pixabaychallenge.ui.theme.PixabayChallengeTheme
import com.example.pixabaychallenge.ui.viewmodels.ImageViewModel


@Composable
fun SearchScreen(imageViewModel: ImageViewModel) {
    var query by remember { mutableStateOf("") }
    val images = imageViewModel.images.value



    LaunchedEffect(query) {
        imageViewModel.searchImages(query)
    }

    Column(modifier = Modifier.fillMaxSize()) {
        TextField(
            value = query,
            onValueChange = { query = it },
            label = { Text("Search for images") },
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        )


        LazyColumn(modifier = Modifier.fillMaxSize()) {
//            items(images) { image ->
//                ListItem(image = image) { imageViewModel.showImageDetails(image.id) }
//            }
            items(images.map { it.id }) { imageId ->
                val image = images.find { it.id == imageId }!!
                ListItem(image = image) { imageViewModel.showImageDetails(imageId.toInt())
                }
            }
        }
    }

    if (imageViewModel.selectedImage.value != null) {
        DetailScreen(imageViewModel = imageViewModel, image = imageViewModel.selectedImage.value!!)
    }

}

//@Preview(showBackground = false)
//@Composable
//fun SimpleComposablePreview() {
//    val api = object : PixabayApi {
//        override suspend fun searchImages(apiKey: String, query: String): SearchResponse {
//
//          return SearchResponse(hits = emptyList())
//        }
//    }
//
//        val dao = object : ImageDao {
//            override suspend fun insertImages(images: List<ImageEntity>) {
//
//            }
//
//            override suspend fun getImageById(id: Int): ImageEntity? {
//
//                return null
//            }
//
//            override suspend fun searchImages(query: String): List<ImageEntity> {
//
//                return emptyList()
//            }
//
//        }
//    val repository = ImageRepositoryImpl(api, dao)
//    val viewModel = ImageViewModel(repository)
//    PixabayChallengeTheme {
//        SearchScreen(viewModel)
//    }
//
//}



