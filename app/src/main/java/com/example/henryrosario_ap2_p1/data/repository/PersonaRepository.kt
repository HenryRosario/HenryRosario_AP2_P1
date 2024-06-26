package com.example.henryrosario_ap2_p1.data.repository

import com.example.henryrosario_ap2_p1.data.remote.PersonaApi
import com.example.henryrosario_ap2_p1.data.remote.dto.PersonaDto
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PersonaRepository @Inject constructor(
    private val personaApi: PersonaApi
) {
    suspend fun getPersona(): Flow<Resource<List<PersonaDto>>> = flow {
        emit(Resource.Loading())
        try {
            val persona = personaApi.getPersona()
            emit(Resource.Success(persona))
        } catch (e: Exception) {
            emit(Resource.Error(e.message ?: "An unexpected error occured"))
        }
    }

    suspend fun createPersona(persona: PersonaDto): Flow<Resource<PersonaDto>> = flow {
        emit(Resource.Loading())
        try {
            val nuevaPersona = personaApi.createPersona(persona)
            emit(Resource.Success(nuevaPersona))
        } catch (e: Exception) {
            emit(Resource.Error(e.message ?: "An unexpected error occurred"))
        }
    }

    suspend fun deletePersona(id: Int): Flow<Resource<Unit>> = flow {
        emit(Resource.Loading())
        try {
            personaApi.deletePersona(id)
            emit(Resource.Success(Unit))
        } catch (e: Exception) {
            emit(Resource.Error(e.message ?: "An unexpected error occurred"))
        }
    }
}

sealed class Resource<T>(val data: T? = null, val message: String? = null) {
    class Loading<T>(data: T? = null) : Resource<T>(data)
    class Success<T>(data: T) : Resource<T>(data)
    class Error<T>(message: String, data: T? = null) : Resource<T>(data, message)
}