package com.eas.dbroom

import com.eas.dbroom.data.User
import com.eas.dbroom.data.UserDao
import kotlinx.coroutines.flow.Flow

class UserRepository(private val userDao: UserDao) {
    fun getAll():  Flow<List<User>> = userDao.getUsers()

    suspend fun insertUser(user: User)
            = userDao.insertUser(user)

    suspend fun deleteAllUsers(allUsers: List<User>)
            = userDao.deleteAllUsers(allUsers)
}