package com.aeryz.pokemonster.ui.screen.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aeryz.pokemonster.data.repository.ProfileRepository
import com.aeryz.pokemonster.model.Profile
import com.aeryz.pokemonster.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ProfileViewModel(private val repository: ProfileRepository) : ViewModel() {
    private val _uiState: MutableStateFlow<UiState<Profile>> = MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<Profile>>
        get() = _uiState

    fun getProfileData() {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            _uiState.value = UiState.Success(repository.getProfileData())
        }
    }
}