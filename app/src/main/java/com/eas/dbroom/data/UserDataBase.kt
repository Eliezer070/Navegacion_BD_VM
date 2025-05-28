package com.eas.dbroom.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [User::class], version = 1)
abstract class UserDataBase: RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object {
        @Volatile
        private var Instance: UserDataBase? = null

        fun getUserDatabase(context: Context): UserDataBase {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(
                    context = context,
                    klass = UserDataBase::class.java,
                    name = "sample"
                )
                    .build()
                    .also { Instance = it }
            }
        }
    }
}