package com.eas.dbroom

import com.eas.dbroom.data.Alumno
import com.eas.dbroom.data.AlumnoDao
import kotlinx.coroutines.flow.Flow

class UserRepository(private val alumnoDao: AlumnoDao) {
    fun getAll(matricula: String):  Flow<List<Alumno>> = alumnoDao.getUsers(matricula)

    suspend fun insertUser(alumno: Alumno)
            = alumnoDao.insertUser(alumno)

    suspend fun deleteAllUsers(allAlumnos: List<Alumno>)
            = alumnoDao.deleteAllUsers(allAlumnos)
}