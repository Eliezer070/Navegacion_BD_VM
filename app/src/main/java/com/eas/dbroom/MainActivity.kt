package com.eas.dbroom

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.eas.dbroom.ui.theme.DBRoomTheme
import com.eas.dbroom.ui.ui.Nav
import com.eas.dbroom.ui.ui.RegisterPageUI

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DBRoomTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val viewModel: RegisterViewModel = viewModel(factory = RegisterViewModel.Factory)
                    Nav(
                        viewModel = viewModel, // ..1
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
