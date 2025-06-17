package com.eas.dbroom.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Alumno::class], version = 1)
abstract class AlumnosDataBase: RoomDatabase() {
    abstract fun AlumnoDao(): AlumnoDao

    companion object {
        @Volatile
        private var Instance: AlumnosDataBase? = null

        fun getUserDatabase(context: Context): AlumnosDataBase {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(
                    context = context,
                    klass = AlumnosDataBase::class.java,
                    name = "AlumnosDB"
                )
                    .build()
                    .also { Instance = it }
            }
        }
    }
}