package com.aeryz.pokemonster.ui.screen.home

import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aeryz.pokemonster.R
import com.aeryz.pokemonster.model.Pokemon
import com.aeryz.pokemonster.ui.common.UiState
import com.aeryz.pokemonster.ui.components.PokemonItem
import com.aeryz.pokemonster.ui.components.SearchBar
import com.aeryz.pokemonster.ui.theme.PokeMonsterTheme
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = koinViewModel(),
    navigateToDetail: (Int) -> Unit,
    navigateToProfile: () -> Unit,
) {
    val query by viewModel.query
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary
                ),
                title = {
                    Text(
                        text = stringResource(R.string.text_pokemonster),
                        color = Color.Yellow,
                        style = MaterialTheme.typography.titleLarge.copy(
                            fontWeight = FontWeight.Bold,
                        ),
                    )
                },
                actions = {
                    IconButton(
                        onClick = { navigateToProfile() },
                        modifier = Modifier
                    ) {
                        Icon(imageVector = Icons.Filled.Person, contentDescription = "about_page")
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = modifier
                .background(MaterialTheme.colorScheme.primary)
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            SearchBar(
                query = query,
                onQueryChange = viewModel::getPokemonData
            )
            viewModel.pokemon.collectAsState(initial = UiState.Loading).value.let { uiState ->
                when (uiState) {
                    is UiState.Loading -> {
                        viewModel.getPokemonData(query)
                    }

                    is UiState.Success -> {
                        PokemonGrid(
                            pokemonList = uiState.data,
                            navigateToDetail = navigateToDetail
                        )
                    }

                    is UiState.Error -> {}
                }
            }
        }
    }
}

@Preview(showBackground = true, device = Devices.PIXEL_3A)
@Composable
fun HomeScreenPreview() {
    PokeMonsterTheme {
        HomeScreen(
            navigateToDetail = {},
            navigateToProfile = {}
        )
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PokemonGrid(
    modifier: Modifier = Modifier,
    pokemonList: List<Pokemon> = emptyList(),
    navigateToDetail: (Int) -> Unit
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier.fillMaxWidth().testTag("PokemonList")
    ) {
        items(pokemonList, key = { it.id }) { pokemon ->
            PokemonItem(
                imageUrl = pokemon.imageUrl,
                name = pokemon.name,
                type = pokemon.type,
                modifier = Modifier
                    .animateItemPlacement(tween(durationMillis = 100))
                    .clickable {
                        navigateToDetail(pokemon.id)
                    }
            )
        }
    }
}