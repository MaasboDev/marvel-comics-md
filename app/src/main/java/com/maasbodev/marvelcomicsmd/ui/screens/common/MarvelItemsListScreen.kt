package com.maasbodev.marvelcomicsmd.ui.screens.common

import androidx.compose.runtime.Composable
import com.maasbodev.marvelcomicsmd.data.entities.MarvelItem

@Composable
fun <T : MarvelItem> MarvelItemsListScreen(
    loading: Boolean = false,
    items: Result<List<T>>,
    onItemClick: (T) -> Unit,
) {

    /*items.fold({})*/
}
