package com.example.pixabaychallenge.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.pixabaychallenge.ui.components.SearchScreen
import com.example.pixabaychallenge.ui.theme.PixabayChallengeTheme
import com.example.pixabaychallenge.ui.viewmodels.ImageViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment : Fragment() {
    private val viewModel: ImageViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                PixabayChallengeTheme {
                    SearchScreen(imageViewModel = viewModel)
                }
            }
        }
    }
}