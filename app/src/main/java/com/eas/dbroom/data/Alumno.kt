package com.eas.dbroom.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "AlumnoData")
data class Alumno(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name = "nombre")
    val nombre: String,
    @ColumnInfo(name = "correo")
    val correo: String,
    @ColumnInfo(name = "edad")
    val edad: String,
    @ColumnInfo(name = "carrera")
    val carrera: String,
    @ColumnInfo(name = "matricula")
    val matricula: String
)
