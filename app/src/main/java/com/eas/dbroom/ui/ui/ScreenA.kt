package com.eas.dbroom.ui.ui

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.eas.dbroom.RegisterViewModel
import com.eas.dbroom.model.AlumnoData


@Composable
fun RegisterPageUI(viewModel: RegisterViewModel, // ..1,
                   modifier: Modifier = Modifier,
                   navController: NavHostController,) {
    var matricula by remember { mutableStateOf("") }
    var nombre by remember { mutableStateOf("") }
    var correo by    remember { mutableStateOf("") }
    var edad by remember { mutableStateOf("") }
    var carrera by remember { mutableStateOf("") }

    val mContext = LocalContext.current
    val keyboardController = LocalSoftwareKeyboardController.current

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        // Main card Content for Register
        ElevatedCard(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .verticalScroll(rememberScrollState()) // Add verticalScroll modifier here
        ) {
            Column(
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .padding(bottom = 8.dp)
            ) {

                Text(
                    modifier = Modifier.padding(top = 16.dp, start = 16.dp),
                    text = "Register",
                    fontSize = 25.sp
                )

                OutlinedTextField(
                    value = matricula,
                    onValueChange = { matricula = it },
                    label = { Text("Matricula") },
                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                )
                // Name Field
                OutlinedTextField(
                    value = nombre, // Add a variable for name
                    onValueChange = { nombre = it },
                    label = { Text("Nombre") },
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                )


                OutlinedTextField(
                    value = correo,
                    onValueChange = { correo = it },
                    label = { Text("Correo") },
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                )



                carreraDropDown(carrera = carrera, onCarreraChange = { newCarrera -> carrera = newCarrera })

                Row(
                    modifier = Modifier.fillMaxWidth().wrapContentSize(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Button(
                        onClick = {
                            if (matricula.isEmpty()) {
                                Toast.makeText(mContext, "La matrícula está vacía", Toast.LENGTH_SHORT).show()
                            } else if (nombre.isEmpty()) {
                                Toast.makeText(mContext, "El nombre está vacío", Toast.LENGTH_SHORT)
                                    .show()
                            } else if (correo.isEmpty()) {
                                Toast.makeText(mContext, "Ingresa un correo", Toast.LENGTH_SHORT)
                                    .show()
                            } else if (edad.isEmpty()) {
                                Toast.makeText(mContext, "Ingresa la edad", Toast.LENGTH_SHORT)
                                    .show()
                            } else if (carrera.isEmpty()) {
                                Toast.makeText(mContext, "Ingresa la carrera", Toast.LENGTH_SHORT)
                                    .show()
                            } else {
                                //Submit you data
                                val user =
                                    AlumnoData(nombre = nombre, matricula = matricula, correo = correo, carrera = carrera, edad = edad)
                                viewModel.insertUser(user)
                                nombre = ""
                                correo = ""
                                matricula = ""
                                edad = ""
                                carrera = ""

                                keyboardController?.hide()
                            }
                        },
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Text("Registar")
                    }
                    Button(
                        onClick = {

                        },
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Text("Consultar")
                    }
                }
            }
        }

    }
}