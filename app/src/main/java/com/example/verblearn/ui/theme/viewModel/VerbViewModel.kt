package com.example.verblearn.ui.theme.viewModel

import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.verblearn.data.remote.dto.VerbsDTO
import com.example.verblearn.data.repository.VerbsRepository
import com.example.verblearn.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import javax.inject.Inject


data class VerbListState(
    val isLoading: Boolean = false,
    val verbs: List<VerbsDTO> = emptyList(),
    val verb: VerbsDTO? = null,
    val error: String = "",
)
@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@HiltViewModel
class VerbViewModel @Inject constructor(private val verbsRepository: VerbsRepository
) : ViewModel(){
    private val _uiState = MutableStateFlow(VerbListState())
    val uiState: StateFlow<VerbListState> = _uiState.asStateFlow()

    init {
        verbsRepository.getVerbs().onEach { result ->
            when (result) {
                is Resource.Loading -> {
                    _uiState.update { it.copy(isLoading = true) }
                }

                is Resource.Success -> {
                    _uiState.update { it.copy(verbs = result.data ?: emptyList()) }
                }

                is Resource.Error -> {
                    _uiState.update { it.copy(error = result.message ?: "Error desconocido") }
                }
            }
        }.launchIn(viewModelScope)
    }
}