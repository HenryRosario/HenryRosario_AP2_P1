package com.example.henryrosario_ap2_p1.data.local.database


import androidx.databinding.adapters.Converters
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.henryrosario_ap2_p1.data.local.dao.ServicioDao
import com.example.henryrosario_ap2_p1.data.local.database.servicioDb
import com.example.henryrosario_ap2_p1.data.local.entities.ServicioEntity
@Database(
    entities = [

        ServicioEntity::class


    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class servicioDb : RoomDatabase() {

    abstract fun servicioDao(): ServicioDao

}