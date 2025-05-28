package com.eas.dbroom.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    @Insert
    suspend fun insertUser(user: User)

    @Delete
    suspend fun deleteAllUsers(allUsers: List<User>)

    @Query("SELECT * from UserData order by id DESC")
    fun getUsers():  Flow<List<User>>
}