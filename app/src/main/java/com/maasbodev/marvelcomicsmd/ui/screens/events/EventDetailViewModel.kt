package com.maasbodev.marvelcomicsmd.ui.screens.events

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import arrow.core.Either
import com.maasbodev.marvelcomicsmd.data.Result
import com.maasbodev.marvelcomicsmd.data.repositories.EventsRepository
import com.maasbodev.marvelcomicsmd.domain.entities.Event
import com.maasbodev.marvelcomicsmd.ui.navigation.NavArg
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class EventDetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    repository: EventsRepository
) : ViewModel() {

    private val id = savedStateHandle.get<Int>(NavArg.ItemId.key) ?: 0

    private val _state = MutableStateFlow(UiState())
    val state = _state.asStateFlow()

    init {

        viewModelScope.launch {
            _state.value = UiState(loading = true)
            _state.value = UiState(event = repository.find(id))
        }
    }

    data class UiState(
        val loading: Boolean = false,
        val event: Result<Event?> = Either.Right(null)
    )
}
