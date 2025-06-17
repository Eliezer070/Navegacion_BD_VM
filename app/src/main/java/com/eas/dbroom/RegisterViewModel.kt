package com.eas.dbroom

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.eas.dbroom.data.Alumno
import com.eas.dbroom.model.AlumnoData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class RegisterViewModel (private val userRepository: UserRepository) : ViewModel() {

    fun getAll(matricula: String): Flow<List<Alumno>> = userRepository.getAll(matricula = matricula)

    fun insertUser(user: AlumnoData) = viewModelScope.launch {
        userRepository.insertUser(Alumno(id =0, nombre = user.nombre, correo = user.correo, edad = user.edad, matricula = user.matricula, carrera = user.carrera))
    }

    fun deleteAll(allAlumnos: List<Alumno>) = viewModelScope.launch {
        userRepository.deleteAllUsers(allAlumnos)
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as UsersApplication)
                RegisterViewModel(application.container.userRepository)
            }
        }
    }
}