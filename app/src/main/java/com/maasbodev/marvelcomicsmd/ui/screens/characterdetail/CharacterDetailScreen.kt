package com.maasbodev.marvelcomicsmd.ui.screens.characterdetail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun CharacterDetailScreen(id: Int) {
	Box(
		contentAlignment = Alignment.Center,
		modifier = Modifier.fillMaxSize(),
	) {
		Text(id.toString())
	}
}