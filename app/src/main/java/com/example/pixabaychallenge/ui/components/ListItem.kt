package com.example.pixabaychallenge.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.pixabaychallenge.models.Image
import com.skydoves.landscapist.coil.CoilImage

@Composable
fun ListItem(
    image: Image,
    onClick: () -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .clickable (onClick = onClick)
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        CoilImage(
            imageModel = {image.previewUrl},
            // contentDescription = image.tags.joinToString(),
            modifier = Modifier.size(64.dp)
        )

        
        Column(modifier = Modifier.padding(start = 16.dp)) {
            Text(text = image.user, fontWeight = FontWeight.Bold)
            Text(text = image.tags.joinToString())
        }
    }
}