package com.example.henryrosario_ap2_p1.data.remote

import com.example.henryrosario_ap2_p1.data.remote.dto.PersonaDto

import retrofit2.http.GET


interface PersonaApi {
    @GET("api/Personas")
    suspend fun getPersona(): List<PersonaDto>

}