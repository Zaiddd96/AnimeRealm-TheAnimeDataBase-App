package com.example.animerealm

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.animerealm.model.Manga

@Composable
fun DetailScreen(manga:Manga) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF001F3F))
        ,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {

        Card(
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFF003366)
            ),
            modifier = Modifier.verticalScroll(rememberScrollState()).padding(16.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        ) {
            Image(
                painter = rememberAsyncImagePainter(model = manga.images.webp.large_image_url),
                contentDescription = manga.title,
                modifier = Modifier
                    .size(300.dp)
                    .padding(16.dp)
                    .align(Alignment.CenterHorizontally)
            )
            Text(
                text = manga.title,
                color = Color.White,
                fontSize = 26.sp,
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier
                    .fillMaxWidth(),
                textAlign = TextAlign.Center
            )
            if (manga.rank != null && manga.rank > 0) {
                Text(
                    text = "${manga.rank} ⭐",
                    color = Color.White,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
            }
            if (manga.favorites > 0) {
                Text(
                    text = "Reviews: ${manga.favorites} \uD83D\uDC65",
                    color = Color.White,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 4.dp, bottom = 4.dp),
                    textAlign = TextAlign.Center
                )
                Text(
                    text = manga.genres.map { it.name }.joinToString(", "),
                    fontSize = 10.sp,
                    color = Color(0x99FFFFFF),
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp),
                    textAlign = TextAlign.Center,
                )
                Text(
                    text = "Synopsis:",
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color(0x99FFFFFF),
                    modifier = Modifier
                        .fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
                Text(
                    text = manga.synopsis,
                    color = Color.White,
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 6.dp, start = 12.dp, end = 16.dp, bottom = 12.dp)

                )
            }
        }
    }
}