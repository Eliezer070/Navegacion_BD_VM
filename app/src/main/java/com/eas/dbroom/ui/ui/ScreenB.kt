package com.eas.dbroom.ui.ui

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.eas.dbroom.RegisterViewModel
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import com.eas.dbroom.data.Alumno
import com.eas.dbroom.model.AlumnoData


@Composable
fun Querys(navController: NavHostController, viewModel: RegisterViewModel) {
    val gradientColors = listOf(Color.Cyan, Color.Magenta, Color.Yellow /*...*/)
    val mContext = LocalContext.current
    var matricula by remember { mutableStateOf("") }
    val usersList by viewModel.getAll(matricula).collectAsState(initial = emptyList())
    //Columna para ver los resultados de la consulta
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        OutlinedTextField(
            value = matricula,
            onValueChange = { matricula = it },
            label = { Text("Matricula") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        )

        Row(
            modifier = Modifier.fillMaxWidth().wrapContentSize(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = {
                    viewModel.getAll(matricula)
                },
                modifier = Modifier.padding(16.dp)
            ) {
                Text("Consultar")
            }
        }

        // Display the list of users with the same matricula
        LazyColumn(
            modifier = Modifier.weight(.7F),
            verticalArrangement = Arrangement.Center
        ) {
            items(usersList) { user ->
                ProductItem(user)
            }
        }
    }
}

@Composable
fun ProductItem(alumno: Alumno) {

}