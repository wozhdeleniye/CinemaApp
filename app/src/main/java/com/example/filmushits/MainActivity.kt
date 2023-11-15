package com.example.filmushits

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.filmushits.Etities.Models.ProfileModel
import com.example.filmushits.Network.Network
import com.example.filmushits.Network.TokenManager
import com.example.filmushits.view.screen.app_screen.AppScreen
import com.example.filmushits.navigation.Nav
import com.example.filmushits.view.screen.app_screen.ProfileScreen.ProfileViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Network.getInstance().setTokenManager(TokenManager(applicationContext))
        Network.getInstance().initialize()
        setContent {
            window.statusBarColor = getColor(R.color.status_bar)
            Nav()
        }
    }
}
