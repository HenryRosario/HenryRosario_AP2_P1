package com.example.henryrosario_ap2_p1.data.repository


import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

//class TareasRepository @Inject constructor(
//    private val tareasApi: TareasAPI
//) {
//    suspend fun getTareas(): Flow<Resource<List<TareasDto>>> = flow {
//        emit(Resource.Loading())
//        try {
//            val tareas = tareasApi.getTareas()
//            emit(Resource.Success(tareas))
//        } catch (e: Exception) {
//            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured"))
//        }
//    }
//}

