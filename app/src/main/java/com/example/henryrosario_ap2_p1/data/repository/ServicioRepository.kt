package com.example.henryrosario_ap2_p1.data.repository


import  com.example.henryrosario_ap2_p1.data.local.dao.ServicioDao
import  com.example.henryrosario_ap2_p1.data.local.entities.ServicioEntity
class ServicioRepository(private val servicioDao: ServicioDao) {
    suspend fun saveServicio(servicio: ServicioEntity) = servicioDao.save(servicio)

    fun getServicio() = servicioDao.getAll()
    suspend fun delete(servicio: ServicioEntity) = servicioDao.delete(servicio)


}