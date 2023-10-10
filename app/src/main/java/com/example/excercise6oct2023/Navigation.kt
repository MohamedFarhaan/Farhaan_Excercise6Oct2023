package com.example.logintaskexcercise5oct2023

import ActionModel
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.excercise6oct2023.screens.HomeScreen
import com.example.excercise6oct2023.screens.PageScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun getNavigation(navController: NavHostController, actionModel: ActionModel) {
    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen(actionModel = actionModel)
        }
        composable("about") {
            PageScreen(LocalContext.current)
        }
    }
}