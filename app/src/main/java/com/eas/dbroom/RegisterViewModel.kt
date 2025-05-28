package com.eas.dbroom

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.eas.dbroom.data.User
import com.eas.dbroom.model.UserData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class RegisterViewModel (private val userRepository: UserRepository) : ViewModel() {

    fun getAll(): Flow<List<User>> = userRepository.getAll()

    fun insertUser(user: UserData) = viewModelScope.launch {
        userRepository.insertUser(User(id =0, name = user.name, email = user.email, phone = user.phone))
    }

    fun deleteAll(allUsers: List<User>) = viewModelScope.launch {
        userRepository.deleteAllUsers(allUsers)
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