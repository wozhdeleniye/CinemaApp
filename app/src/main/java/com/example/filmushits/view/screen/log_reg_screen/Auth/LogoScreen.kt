package com.example.filmushits.view.screen.log_reg_screen.Auth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.filmushits.Etities.Models.ProfileModel
import com.example.filmushits.view.screen.app_screen.ProfileScreen.ProfileViewModel
import com.example.filmushits.view.theme.BackGroundColor

@Composable
fun LogoScreen(navController: NavHostController) {
    val checkViewModel: ProfileViewModel = viewModel()
    var profileData by remember { mutableStateOf<ProfileModel?>(null) }
    LaunchedEffect(Unit){
        val job = checkViewModel.getProfile().await()
        if(job != null){
            navController.navigate("AppScreen")
        }
        else{
            navController.navigate("LogRegScreen")
        }
    }
    Column(
        modifier = Modifier.fillMaxSize()
            .background(BackGroundColor)
    ){

    }
}