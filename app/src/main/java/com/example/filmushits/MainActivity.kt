package com.example.filmushits

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.filmushits.log_reg_screens.RegScreen1
import com.example.filmushits.log_reg_screens.RegScreen2
import com.example.filmushits.ui.theme.FilmusHitSTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            FilmusHitSTheme {
                NavHost(
                    navController = navController,
                    startDestination = "logregscreen"
                ) {
                    composable("logregscreen") {
                        RegScreen2()
                    }
                }
            }
        }
    }
}