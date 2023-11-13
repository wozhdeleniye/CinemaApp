package com.example.filmushits.view.screen.app_screen

import com.example.filmushits.R

sealed class BottomItem(val title: String, val iconId: Int, val route: String) {
    object MainScreen : BottomItem("Главная", R.drawable.main_screen_icon, "main_screen")
    object LikedScreen: BottomItem("Любимое", R.drawable.liked_screen_icon, "liked_screen")
    object ProfileScreen: BottomItem("Профиль", R.drawable.profile_screen_icon, "profile_screen")
}
