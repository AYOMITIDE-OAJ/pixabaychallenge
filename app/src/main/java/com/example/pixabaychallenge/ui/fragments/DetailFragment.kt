package com.example.pixabaychallenge.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.pixabaychallenge.ui.components.DetailScreen
import com.example.pixabaychallenge.ui.theme.PixabayChallengeTheme
import com.example.pixabaychallenge.ui.viewmodels.DetailViewModel
import com.example.pixabaychallenge.ui.viewmodels.ImageViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment() {
    private val viewModel: ImageViewModel by viewModels()
    private val args: DetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val imageId = args.imageId
        viewModel.showImageDetails(imageId)

        return ComposeView(requireContext()).apply {
            setContent {
                PixabayChallengeTheme {
                    DetailScreen(imageViewModel = viewModel, image = viewModel.selectedImage.value!!)
                }
            }
        }
    }
}