package com.aeryz.pokemonster.ui.screen.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aeryz.pokemonster.data.repository.PokemonRepository
import com.aeryz.pokemonster.model.Pokemon
import com.aeryz.pokemonster.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DetailViewModel(
    private val repository: PokemonRepository
) : ViewModel() {
    private val _uiState: MutableStateFlow<UiState<Pokemon>> = MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<Pokemon>>
        get() = _uiState

    fun getPokemonDetailById(pokemonId: Int) {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            _uiState.value = UiState.Success(repository.getPokemonDetail(pokemonId))
        }
    }
}