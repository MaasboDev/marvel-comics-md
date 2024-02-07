package com.maasbodev.marvelcomicsmd.ui.screens.characters

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.maasbodev.marvelcomicsmd.domain.entities.Character
import com.maasbodev.marvelcomicsmd.ui.screens.common.MarvelItemDetailScreen
import com.maasbodev.marvelcomicsmd.ui.screens.common.MarvelItemsListScreen

@Composable
fun CharactersScreen(
    onclick: (Character) -> Unit,
    viewModel: CharactersViewModel = hiltViewModel(),
) {
    val state by viewModel.state.collectAsState()

    MarvelItemsListScreen(
        loading = state.loading,
        items = state.characters,
        onClick = onclick,
    )
}

@Composable
fun CharacterDetailScreen(viewModel: CharactersDetailViewModel = hiltViewModel()) {
    val state by viewModel.state.collectAsState()

    MarvelItemDetailScreen(loading = state.loading, marvelItem = state.character)
}
