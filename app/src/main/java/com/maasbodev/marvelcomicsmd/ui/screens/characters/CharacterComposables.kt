package com.maasbodev.marvelcomicsmd.ui.screens.characters

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.maasbodev.marvelcomicsmd.data.entities.Character

@Composable
fun CharactersScreen(
    onclick: (Character) -> Unit,
    viewModel: CharactersDetailViewModel = hiltViewModel(),
) {
    /*val state by viewModel.state.collectAsState()*/
}

@Composable
fun CharacterDetailScreen(character: Character, modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier.padding(8.dp)
    ) {
        Card {
            Image(
                painter = rememberAsyncImagePainter(model = character.thumbnail),
                contentDescription = character.title,
                modifier = Modifier
                    .background(Color.LightGray)
                    .fillMaxWidth()
                    .aspectRatio(1f),
                contentScale = ContentScale.Crop,
            )
        }
        Text(
            text = character.title,
            style = MaterialTheme.typography.titleMedium,
            maxLines = 2,
            modifier = Modifier.padding(8.dp, 16.dp),
        )
    }
}
