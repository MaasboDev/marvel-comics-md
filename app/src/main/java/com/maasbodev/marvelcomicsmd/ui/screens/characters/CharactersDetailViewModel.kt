package com.maasbodev.marvelcomicsmd.ui.screens.characters

import androidx.lifecycle.ViewModel
import com.maasbodev.marvelcomicsmd.data.repositories.CharactersRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CharactersDetailViewModel @Inject constructor(private val repository: CharactersRepository) :
    ViewModel() {
}
