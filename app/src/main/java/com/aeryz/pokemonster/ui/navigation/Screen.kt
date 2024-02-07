package com.aeryz.pokemonster.ui.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Profile : Screen("profile")
    object Detail: Screen("home/{pokemonId}") {
        fun createRoute(pokemonId: Int) = "home/$pokemonId"
    }
}