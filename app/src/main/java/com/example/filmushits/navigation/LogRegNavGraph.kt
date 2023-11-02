package com.example.filmushits.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.filmushits.app_screens.AppScreen
import com.example.filmushits.log_reg_screens.LogRegScreen
import com.example.filmushits.log_reg_screens.LogScreen
import com.example.filmushits.log_reg_screens.RegScreen1
import com.example.filmushits.log_reg_screens.RegScreen2


@Composable
fun Nav() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "LogRegScreen"){
        composable(route = "LogRegScreen"){
            LogRegScreen(navController)
        }
        composable(route = "LogScreen"){
            LogScreen(navController)
        }
        composable(route = "RegScreen1"){
            RegScreen1(navController)
        }
        composable(route = "RegScreen2"){
            RegScreen2(navController)
        }
        composable(route = "AppScreen"){
            AppScreen()
        }
    }
}