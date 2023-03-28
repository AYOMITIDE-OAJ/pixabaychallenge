package com.example.pixabaychallenge.ui.viewmodels

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pixabaychallenge.models.Image
import com.example.pixabaychallenge.repositories.ImageRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch


class DetailViewModel @ViewModelInject constructor(private val imageRepository: ImageRepository) : ViewModel() {
    private val _selectedImage = mutableStateOf<Image?>(null)
    val selectedImage: State<Image?> = _selectedImage

    fun loadImageDetails(imageId: Int) {
        viewModelScope.launch {
            _selectedImage.value = imageRepository.getImageById(imageId)
        }
    }

    fun dismissImageDetails() {
        _selectedImage.value = null
    }
}
