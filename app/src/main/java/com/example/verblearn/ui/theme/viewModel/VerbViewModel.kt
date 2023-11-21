package com.example.verblearn.ui.theme.viewModel

import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewModelScope
import com.example.verblearn.data.remote.dto.VerbsDTO
import com.example.verblearn.data.repository.VerbsRepository
import com.example.verblearn.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.forEach
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.util.Locale
import javax.inject.Inject


data class VerbListState(
    val isLoading: Boolean = false,
    val verbs: List<VerbsDTO> = emptyList(),
    val verb: VerbsDTO? = null,
    val error: String = "",
)
@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@HiltViewModel
class VerbViewModel @Inject constructor(
    private val verbsRepository: VerbsRepository,
) : ViewModel() {
    var verb by mutableStateOf(VerbsDTO())
    var idVerb by mutableStateOf(0)
    var baseForm by mutableStateOf("")
    var pastParticiple by mutableStateOf("")
    var simplePast by mutableStateOf("")
    var definition by mutableStateOf("")

    var spanishBaseForm by mutableStateOf("")
    var spanishPastParticiple by mutableStateOf("")
    var spanishSimplePast by mutableStateOf("")
    var definitionInSpanish by mutableStateOf("")
    var verbProposal by mutableStateOf("")

    private val _uiState = MutableStateFlow(VerbListState())
    val uiState: StateFlow<VerbListState> = _uiState.asStateFlow()


    init {
        cargar()
    }

    fun cargar() {
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

    fun getVerbById(id: Int) {
        viewModelScope.launch {
            verb = verbsRepository.getVerbsById(id)!!
        }
    }


}
