package com.eas.dbroom

import android.content.Context
import com.eas.dbroom.data.AlumnosDataBase

class UsersContainer (private val context: Context) {
    val userRepository: UserRepository by lazy {
        UserRepository(AlumnosDataBase.getUserDatabase(context).AlumnoDao())
    }
}