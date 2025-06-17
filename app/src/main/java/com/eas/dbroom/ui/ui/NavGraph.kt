package com.eas.dbroom.ui.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.eas.dbroom.RegisterViewModel

@Composable
fun Nav(viewModel: RegisterViewModel, // ..1,
        modifier: Modifier = Modifier){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "A") {
        composable(route = "A") {
            RegisterPageUI(viewModel, modifier, navController)
        }


    }
}
