package com.maasbodev.marvelcomicsmd.ui.screens.comics

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import arrow.core.Either
import arrow.core.right
import com.maasbodev.marvelcomicsmd.data.entities.Comic
import com.maasbodev.marvelcomicsmd.data.entities.Result
import com.maasbodev.marvelcomicsmd.data.repositories.ComicsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class ComicsViewModel @Inject constructor(private val repository: ComicsRepository) : ViewModel() {

    val state = Comic.Format.entries.associate { it to MutableStateFlow(UiState()) }

    fun formatRequested(format: Comic.Format) {
        val uiState = state.getValue(format)
        val comics = uiState.value.comics
        if (comics is Either.Right && comics.value.isEmpty()) {
            viewModelScope.launch {
                uiState.value = UiState(loading = true)
                uiState.value = UiState(comics = repository.get(format))
            }
        }
    }

    data class UiState(
        val loading: Boolean = false,
        val comics: Result<List<Comic>> = emptyList<Comic>().right()
    )
}
