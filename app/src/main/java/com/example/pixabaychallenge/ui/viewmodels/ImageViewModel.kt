package com.example.pixabaychallenge.ui.viewmodels

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pixabaychallenge.models.Image
import com.example.pixabaychallenge.repositories.ImageRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch


class ImageViewModel @ViewModelInject constructor(private val imageRepository: ImageRepository) : ViewModel() {

    private val _images = mutableStateOf(emptyList<Image>())
    val images: State<List<Image>> = _images

    private val _selectedImage = mutableStateOf<Image?>(null)
    val selectedImage: State<Image?> = _selectedImage

    init {
        viewModelScope.launch {
            searchImages("fruits")
        }
    }

    suspend fun searchImages(query: String): List<Image> {
        Log.d("ImageViewModel", "Searching for images with query: $query")
        val result = imageRepository.searchImages(query)
          _images.value = result
          return result;
    }

//    suspend fun searchImages(query: String) {
//        val result = imageRepository.searchImages(query)
//        _images.clear()
//        _images.addAll(result)
//    }

    fun showImageDetails(id: Int) {
        viewModelScope.launch {
            _selectedImage.value = imageRepository.getImageById(id)
        }
    }

    fun dismissImageDetails() {
        _selectedImage.value = null
    }
}