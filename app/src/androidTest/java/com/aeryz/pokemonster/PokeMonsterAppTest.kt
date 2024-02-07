package com.aeryz.pokemonster

import androidx.activity.ComponentActivity
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performScrollToIndex
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.testing.TestNavHostController
import com.aeryz.pokemonster.data.datasource.DummyPokeMonsterDataSourceImpl
import com.aeryz.pokemonster.ui.navigation.Screen
import com.aeryz.pokemonster.ui.theme.PokeMonsterTheme
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class PokeMonsterAppTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()
    private lateinit var navController: TestNavHostController

    @Before
    fun setUp() {
        composeTestRule.setContent {
            PokeMonsterTheme {
                navController = TestNavHostController(LocalContext.current)
                navController.navigatorProvider.addNavigator(ComposeNavigator())
                PokeMonsterApp(navController = navController)
            }
        }
    }

    @Test
    fun navHost_verifyStartDestination() {
        navController.assertCurrentRouteName(Screen.Home.route)
    }

    @Test
    fun navHost_clickItem_navigatesToDetailWithData() {
        composeTestRule.onNodeWithTag("PokemonList").performScrollToIndex(10)
        composeTestRule.onNodeWithText(DummyPokeMonsterDataSourceImpl().getPokemonData()[10].name).performClick()
        navController.assertCurrentRouteName(Screen.Detail.route)
        composeTestRule.onNodeWithText(DummyPokeMonsterDataSourceImpl().getPokemonData()[10].name).assertIsDisplayed()
    }

    @Test
    fun navHost_clickItem_navigatesBack() {
        composeTestRule.onNodeWithTag("PokemonList").performScrollToIndex(10)
        composeTestRule.onNodeWithText(DummyPokeMonsterDataSourceImpl().getPokemonData()[10].name).performClick()
        navController.assertCurrentRouteName(Screen.Detail.route)
        composeTestRule.onNodeWithContentDescription(composeTestRule.activity.getString(R.string.text_go_to_back)).performClick()
        navController.assertCurrentRouteName(Screen.Home.route)
    }
}