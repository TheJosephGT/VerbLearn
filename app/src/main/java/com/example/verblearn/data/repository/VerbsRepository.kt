package com.example.verblearn.data.repository

import android.os.Build
import androidx.annotation.RequiresExtension
import com.example.verblearn.data.remote.VerbsAPI
import com.example.verblearn.data.remote.dto.VerbsDTO
import com.example.verblearn.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
class VerbsRepository @Inject constructor(private val api: VerbsAPI) {
    fun getVerbs(): Flow<Resource<List<VerbsDTO>>> = flow {
        try {
            emit(Resource.Loading())

            val verb = api.getVerbs()

            emit(Resource.Success(verb))
        } catch (e: HttpException) {
            emit(Resource.Error(e.message ?: "Error HTTP"))
        } catch (e: IOException) {

            emit(Resource.Error(e.message ?: "verificar tu conexion a internet"))
        }
    }

    suspend fun getVerbsById(id: Int): VerbsDTO? {
        return api.getVerbsById(id)
    }

    suspend fun postVerb(verb: VerbsDTO) = api.postVerbs(verb)
}