package com.example.filmushits

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.graphics.Color
import com.example.filmushits.view.screen.app_screen.AppScreen
import com.example.filmushits.navigation.Nav

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            window.statusBarColor = getColor(R.color.status_bar)
            var f = true
            if(f) Nav()
            else AppScreen()
        }
    }
}
