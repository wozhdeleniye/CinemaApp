package com.example.filmushits.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.filmushits.view.screen.app_screen.FavoriteScreen.FavoriteScreen
import com.example.filmushits.view.screen.app_screen.FilmScreen.FilmScreen
import com.example.filmushits.view.screen.app_screen.MainScreen.MainScreen
import com.example.filmushits.view.screen.app_screen.ProfileScreen.ProfileScreen

@Composable
fun BottomBarNavGraph(
    navHostController: NavHostController
){
    NavHost(navController = navHostController, startDestination = "main_screen"){

        composable("main_screen"){
            MainScreen(navHostController)
        }
        composable("liked_screen"){
            FavoriteScreen(navHostController)
        }
        composable("profile_screen"){
            ProfileScreen()
        }
        composable(
            route = "FilmScreen/{id}",
            arguments = listOf(navArgument("id") {type = NavType.StringType})
        ) { backStackEntry ->
            FilmScreen(navHostController, backStackEntry.arguments?.getString("id")!!)
        }
    }
}