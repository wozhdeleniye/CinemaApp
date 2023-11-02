package com.example.filmushits

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.filmushits.app_screens.AppScreen
import com.example.filmushits.navigation.Nav

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var f = true
            if(f) Nav()
            else AppScreen()
        }
    }
}
