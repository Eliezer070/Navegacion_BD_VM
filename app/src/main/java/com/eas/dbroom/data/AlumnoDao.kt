package com.eas.dbroom.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface AlumnoDao {

    @Insert
    suspend fun insertUser(alumno: Alumno)

    @Delete
    suspend fun deleteAllUsers(allAlumnos: List<Alumno>)

    @Query("SELECT * from AlumnoData order by id DESC")
    fun getUsers(matricula: String?):  Flow<List<Alumno>>
}