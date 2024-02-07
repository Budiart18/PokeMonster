package com.aeryz.pokemonster.ui.screen.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aeryz.pokemonster.data.repository.PokemonRepository
import com.aeryz.pokemonster.model.Pokemon
import com.aeryz.pokemonster.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeViewModel(
    private val repository: PokemonRepository
) : ViewModel() {
    private val _pokemon : MutableStateFlow<UiState<List<Pokemon>>> = MutableStateFlow(UiState.Loading)
    val pokemon: StateFlow<UiState<List<Pokemon>>>
        get() = _pokemon

    private val _query = mutableStateOf("")
    val query: State<String> get() = _query

    fun getPokemonData(newQuery: String) {
        viewModelScope.launch {
            _query.value = newQuery
            repository.getPokemonData(_query.value).collect {
                _pokemon.value = UiState.Success(it)
            }
        }
    }
}