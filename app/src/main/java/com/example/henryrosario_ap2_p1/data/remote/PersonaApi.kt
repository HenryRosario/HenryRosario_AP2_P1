package com.example.henryrosario_ap2_p1.data.remote

import com.example.henryrosario_ap2_p1.data.remote.dto.PersonaDto
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path


interface PersonaApi {
    @GET("api/Personas")
    suspend fun getPersona(): List<PersonaDto>

    @POST("api/Personas")
    suspend fun createPersona(@Body persona: PersonaDto): PersonaDto

    @DELETE("api/Personas/{id}")
    suspend fun deletePersona(@Path("id") id: Int)
}