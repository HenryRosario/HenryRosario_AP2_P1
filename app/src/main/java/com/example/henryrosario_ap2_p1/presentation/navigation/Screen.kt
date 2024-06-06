package com.example.henryrosario_ap2_p1.presentation.navigation
import kotlinx.serialization.Serializable
sealed class Screen {

    @Serializable

    object  List : Screen()

    @Serializable
    data class Registro(val ServicoId: Int): Screen()

}