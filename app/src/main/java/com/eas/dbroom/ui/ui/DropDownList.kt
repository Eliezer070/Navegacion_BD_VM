package com.eas.dbroom.ui.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.eas.dbroom.R

@Composable
fun carreraDropDown(carrera: String, onCarreraChange: (String) -> Unit) {

    val isDropDownExpanded = remember {
        mutableStateOf(false)
    }
    val carreras =
        listOf("Informática", "Enfermería", "Odontología", "Medicina", "Ciencias Empresariales")


    val itemPosition = remember {
        mutableStateOf(0)
    }


    Column(
        modifier = Modifier.padding(16.dp).fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {

        Box {
                Row(
                    horizontalArrangement = Arrangement.Absolute.Left,
                    verticalAlignment = Alignment.CenterVertically,

                    modifier = Modifier.clickable {
                        isDropDownExpanded.value = true
                    }.drawBehind {

                        val strokeWidth = 2 * density
                        val y = size.height - strokeWidth / 2


                        drawRect(
                            Color.LightGray,
                            topLeft = Offset(0f, 0f),
                            size = size
                        )
                    }.fillMaxWidth())
                {
                    Text(
                        modifier = Modifier.padding(16.dp),
                        text = carreras[itemPosition.value])
                    Image(
                    painter = painterResource(id = R.drawable.drop_down_icon),
                    contentDescription = "DropDown Icon"
                )
                }
                DropdownMenu(
                    expanded = isDropDownExpanded.value,
                    onDismissRequest = {
                        isDropDownExpanded.value = false
                    }) {
                    carreras.forEachIndexed { index, carrerait ->
                        DropdownMenuItem(
                            text = {
                                Text(text = carrerait)
                            },
                            onClick = {
                                isDropDownExpanded.value = false
                                itemPosition.value = index
                                onCarreraChange(carreras[index])
                            })
                    }
                }
            }

        }
    }

