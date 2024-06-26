package com.example.henryrosario_ap2_p1.data.repository


import  com.example.henryrosario_ap2_p1.data.local.dao.ServicioDao
import  com.example.henryrosario_ap2_p1.data.local.entities.ServicioEntity
import javax.inject.Inject

class ServicioRepository @Inject constructor(
    private val servicioDao: ServicioDao
) {
    suspend fun saveServicio(servicio: ServicioEntity) = servicioDao.save(servicio)
    suspend fun deleteServicio(servicio: ServicioEntity) = servicioDao.delete(servicio)
    fun getServicios() = servicioDao.getAll()
    suspend fun getServicio(id: Int) = servicioDao.find(id)
}