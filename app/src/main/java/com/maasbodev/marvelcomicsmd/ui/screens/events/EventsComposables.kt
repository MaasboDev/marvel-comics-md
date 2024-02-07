package com.maasbodev.marvelcomicsmd.ui.screens.events

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.maasbodev.marvelcomicsmd.domain.entities.Event
import com.maasbodev.marvelcomicsmd.ui.screens.common.MarvelItemDetailScreen
import com.maasbodev.marvelcomicsmd.ui.screens.common.MarvelItemsListScreen

@Composable
fun EventsScreen(
    onClick: (Event) -> Unit,
    viewModel: EventsViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()

    MarvelItemsListScreen(
        items = state.events,
        onClick = onClick,
        loading = state.loading
    )
}

@Composable
fun EventDetailScreen(
    viewModel: EventDetailViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
    MarvelItemDetailScreen(state.loading, state.event)
}
