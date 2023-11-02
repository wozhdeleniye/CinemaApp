package com.example.filmushits.app_screens

import androidx.compose.foundation.background
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.NavigationDrawerItemColors
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomNavigation(
    navControler: NavController
) {
    val listItems = listOf(
        BottomItem.MainScreen,
        BottomItem.LikedScreen,
        BottomItem.ProfileScreen
    )

    NavigationBar(
        Modifier.background(Color.White)
    ) {
        val backStackEntry by navControler.currentBackStackEntryAsState()
        val currentRoute = backStackEntry?.destination?.route
        listItems.forEach { item-> 
            NavigationBarItem(
                selected = currentRoute == item.route,
                onClick = {
                    navControler.navigate(item.route)
                },
                icon = {
                    Icon(
                        painter = painterResource(id = item.iconId),
                        contentDescription = "Icon"
                    )
                },
                label = {
                    Text(
                        text = item.title,
                        fontSize = 9.sp
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color("#FC315E".toColorInt()),
                    selectedTextColor = Color("#FC315E".toColorInt()),
                    unselectedIconColor = Color("#909499".toColorInt()),
                    unselectedTextColor = Color("#909499".toColorInt())
                )
            )

        }
    }
}