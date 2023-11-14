package com.example.filmushits.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.filmushits.view.screen.app_screen.LikedScreen
import com.example.filmushits.view.screen.app_screen.MainScreen.MainScreen
import com.example.filmushits.view.screen.app_screen.ProfileScreen.ProfileScreen

@Composable
fun AppNavGraph(
    navHostController: NavHostController
){
    NavHost(navController = navHostController, startDestination = "main_screen"){
        composable("main_screen"){
            MainScreen()
        }
        composable("liked_screen"){
            LikedScreen()
        }
        composable("profile_screen"){
            ProfileScreen()
        }

    }
}