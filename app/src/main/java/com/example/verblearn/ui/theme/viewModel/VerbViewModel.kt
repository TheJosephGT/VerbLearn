package com.example.verblearn.ui.theme.viewModel

import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.verblearn.data.local.FavoriteRepository
import com.example.verblearn.data.local.entities.Favorite
import com.example.verblearn.data.remote.dto.VerbsDTO
import com.example.verblearn.data.repository.VerbsRepository
import com.example.verblearn.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
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
    private val favoriteRepository: FavoriteRepository,
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
    var verbProposal by mutableStateOf(true)

    //validaciones

    var verificarBassForm by mutableStateOf(true)
    var verificarPastParticiple by mutableStateOf(true)
    var verificarSimplePast by mutableStateOf(true)
    var verificarDefinition by mutableStateOf(true)
    var verificarSpanishBaseForm by mutableStateOf(true)
    var verificarSpanishPastParticiple by mutableStateOf(true)
    var verificarSpanishSimplePast by mutableStateOf(true)
    var verificarDefinitionInSpanish by mutableStateOf(true)

    var favorites : StateFlow<List<Favorite>> = favoriteRepository.getAll().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000),
        initialValue = emptyList()
    )

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
    fun send() {
        viewModelScope.launch {
            val verbs = VerbsDTO(
                id = idVerb,
                baseForm = baseForm,
                pastParticiple = pastParticiple,
                simplePast = simplePast,
                definition = definition,
                spanishBaseForm = spanishBaseForm,
                spanishPastParticiple = spanishPastParticiple,
                spanishSimplePast = spanishSimplePast,
                definitionInSpanish = definitionInSpanish,
                verbProposal = verbProposal
            )
            verbsRepository.postVerb(verbs)
            clear()
            cargar()
        }
    }

    fun saveVerbAsFavorite(verb: VerbsDTO){
        viewModelScope.launch {
            val Favorite = Favorite(
                baseForm = verb.baseForm,
                pastParticiple = verb.pastParticiple,
                simplePast = verb.simplePast,
                definition = verb.definition,
                spanishBaseForm = verb.spanishBaseForm,
                spanishPastParticiple = verb.spanishPastParticiple,
                spanishSimplePast = verb.spanishSimplePast,
                definitionInSpanish = verb.definitionInSpanish,
                verbProposal = verb.verbProposal,
                isFavorite = true
            )
            favoriteRepository.save(Favorite)
        }
    }

    fun deleteVerbAsAVerb(favorite: Favorite){
        viewModelScope.launch {
            favorite.isFavorite = false
            favoriteRepository.delete(favorite)
        }
    }

    fun clear()
    {
        idVerb = 0
        baseForm = ""
        pastParticiple = ""
        simplePast = ""
        definition = ""
        spanishBaseForm = ""
        spanishPastParticiple = ""
        spanishSimplePast = ""
        definitionInSpanish = ""
    }

    fun validar() : Boolean
    {
        verificarBassForm = baseForm != ""
        verificarPastParticiple = pastParticiple != ""
        verificarSimplePast = simplePast != ""
        verificarDefinition = definition != ""
        verificarSpanishBaseForm = spanishBaseForm != ""
        verificarSpanishPastParticiple = spanishPastParticiple != ""
        verificarSpanishSimplePast = spanishSimplePast != ""
        verificarDefinitionInSpanish = definitionInSpanish != ""

        return !(baseForm == "" || pastParticiple == "" || simplePast == "" || definition == ""|| spanishBaseForm == "" ||spanishPastParticiple == "" || spanishSimplePast == "" || definitionInSpanish == "")
    }

}
