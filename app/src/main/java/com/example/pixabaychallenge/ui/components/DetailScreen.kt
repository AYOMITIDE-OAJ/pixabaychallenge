package com.example.pixabaychallenge.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.pixabaychallenge.models.Image
import com.example.pixabaychallenge.ui.viewmodels.ImageViewModel
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.coil.CoilImage

@Composable
fun DetailScreen(imageViewModel: ImageViewModel, image: Image) {
    Dialog(
        onDismissRequest = { imageViewModel.dismissImageDetails() }
    ) {
        Column(
            modifier = Modifier
                .background(androidx.compose.ui.graphics.Color.White)
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            CoilImage(
                imageModel = {image.largeImageUrl},
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
                    .clip(RoundedCornerShape(8.dp)),
                imageOptions =ImageOptions(
                    contentScale = ContentScale.Crop,
                    alignment = Alignment.Center // Check this if this aligns
                )

            )

            Spacer(modifier = Modifier.height(16.dp))

            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = image.user, fontWeight = FontWeight.Bold)
                Text(text = image.tags.joinToString())
                Text(text = "Likes: ${image.likes}")
                Text(text = "Downloads: ${image.downloads}")
                Text(text = "Comments: ${image.comments}")
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = { imageViewModel.dismissImageDetails() },
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                Text(text = "Close")
            }
        }
    }
}
