package com.aeryz.pokemonster

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.aeryz.pokemonster.ui.navigation.Screen
import com.aeryz.pokemonster.ui.screen.detail.DetailScreen
import com.aeryz.pokemonster.ui.screen.home.HomeScreen
import com.aeryz.pokemonster.ui.screen.profile.ProfileScreen
import com.aeryz.pokemonster.ui.theme.PokeMonsterTheme

@Composable
fun PokeMonsterApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    Scaffold(modifier = modifier) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screen.Home.route) {
                HomeScreen(
                    navigateToDetail = { pokemonId ->
                        navController.navigate(Screen.Detail.createRoute(pokemonId))
                    },
                    navigateToProfile = {
                        navController.navigate(Screen.Profile.route)
                    }
                )
            }
            composable(Screen.Profile.route) {
                ProfileScreen(navigateBack = { navController.navigateUp() })
            }
            composable(
                Screen.Detail.route,
                arguments = listOf(navArgument("pokemonId") { type = NavType.IntType })
            ) {
                val id = it.arguments?.getInt("pokemonId") ?: 0
                DetailScreen(
                    pokemonId = id,
                    navigateBack = { navController.navigateUp() }
                )
            }
        }
    }
}

@Preview(showBackground = true, device = Devices.PIXEL_3A)
@Composable
fun PokeMonsterAppPreview() {
    PokeMonsterTheme {
        PokeMonsterApp()
    }
}