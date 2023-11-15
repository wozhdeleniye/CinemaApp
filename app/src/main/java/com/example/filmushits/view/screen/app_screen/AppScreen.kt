package com.example.filmushits.view.screen.app_screen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.filmushits.navigation.BottomBarNavGraph

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AppScreen() {
    val navHostController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomNavigation(navControler = navHostController)
        }
    ) {
        Box(modifier = Modifier.padding(it)){
            BottomBarNavGraph(navHostController)
        }
    }
}