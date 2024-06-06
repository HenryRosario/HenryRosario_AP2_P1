package com.example.henryrosario_ap2_p1.presentation.servicio

import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.henryrosario_ap2_p1.data.local.entities.ServicioEntity
import com.example.henryrosario_ap2_p1.data.repository.ServicioRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch


class ServicioViewModel(private val repository: ServicioRepository) : ViewModel() {

    val servicios = repository.getServicio()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = emptyList()
        )

    fun saveServicio(servicios: ServicioEntity) {
        viewModelScope.launch {
            repository.saveServicio(servicios)
        }
    }

    fun deleteServicio( servicios: ServicioEntity) {
        viewModelScope.launch {
            repository.delete(servicios)
        }
    }


    companion object {
        fun provideFactory(
            repository: ServicioRepository
        ): AbstractSavedStateViewModelFactory =
            object : AbstractSavedStateViewModelFactory() {
                @Suppress("UNCHECKED_CAST")
                override fun <T : ViewModel> create(
                    key: String,
                    modelClass: Class<T>,
                    handle: SavedStateHandle
                ): T {
                    return ServicioViewModel(repository) as T
                }
            }
    }
}