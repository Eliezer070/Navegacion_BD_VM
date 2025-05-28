package com.eas.dbroom

import android.content.Context
import com.eas.dbroom.data.UserDataBase

class UsersContainer (private val context: Context) {
    val userRepository: UserRepository by lazy {
        UserRepository(UserDataBase.getUserDatabase(context).userDao())
    }
}