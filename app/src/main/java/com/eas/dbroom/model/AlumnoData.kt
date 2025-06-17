package com.eas.dbroom.model

import com.eas.dbroom.data.Alumno

data class AlumnoData (
    val nombre: String,
    val correo: String,
    val edad: String,
    val matricula: String,
    val carrera: String
)

fun AlumnoData.toItem()= Alumno(
    id = 0,
    nombre = nombre,
    correo = correo,
    edad = edad,
    matricula = matricula,
    carrera = carrera
)