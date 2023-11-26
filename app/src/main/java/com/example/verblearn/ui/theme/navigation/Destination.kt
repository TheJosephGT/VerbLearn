package com.example.verblearn.ui.theme.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.StarOutline
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Destination(val route: String, val icon: ImageVector, val title: String) {
    object Support : Destination(
        route = "Support", icon = Icons.Filled.Person,
        title = "Support"
    )

    object Home : Destination(
        route = "Home", icon = Icons.Filled.Home,
        title = "Home"
    )

    object Favorites : Destination(
        route = "Favorites", icon = Icons.Filled.Star,
        title = "Favorites"
    )

    object Translate : Destination(
        route = "Translate", icon = Icons.Filled.Email,
        title = "Translate"
    )


    object Splash : Destination(
        route = "Splash", icon = Icons.Filled.Info,
        title = "Splash"
    )

    companion object {
        val toList = listOf(Support, Home, Favorites)
    }
}