package com.aeryz.pokemonster.ui.screen.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.aeryz.pokemonster.R
import com.aeryz.pokemonster.ui.common.UiState
import com.aeryz.pokemonster.ui.components.getBackgroundColorForType
import com.aeryz.pokemonster.ui.theme.PokeMonsterTheme
import org.koin.androidx.compose.koinViewModel

@Composable
fun DetailScreen(
    pokemonId: Int,
    modifier: Modifier = Modifier,
    viewModel: DetailViewModel = koinViewModel(),
    navigateBack: () -> Unit,
) {
    viewModel.uiState.collectAsState(initial = UiState.Loading).value.let { uiState ->
        when (uiState) {
            is UiState.Loading -> {
                viewModel.getPokemonDetailById(pokemonId)
            }

            is UiState.Success -> {
                val data = uiState.data
                DetailContent(
                    name = data.name,
                    type = data.type,
                    imageUrl = data.imageUrl,
                    description = data.description,
                    attack = data.attack,
                    defense = data.defense,
                    speed = data.speed,
                    onBackClick = navigateBack
                )
            }

            is UiState.Error -> {}
        }
    }
}

@Preview(showBackground = true, device = Devices.PIXEL_3A)
@Composable
fun DetailScreenPreview() {
    PokeMonsterTheme {
        DetailContent(
            name = "Dialga",
            type = "Steel",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/483.png",
            description = "A legendary Pokémon of Sinnoh. It is said that time flows when Dialga's heart beats.",
            attack = 120,
            defense = 120,
            speed = 90,
            onBackClick = {}
        )
    }
}

@Composable
fun DetailContent(
    name: String,
    type: String,
    imageUrl: String,
    description: String,
    attack: Int,
    defense: Int,
    speed: Int,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val colorGradients = arrayOf(
        0.0f to getBackgroundColorForType(type),
        0.5f to Color.White
    )
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .background(MaterialTheme.colorScheme.primary)
            .fillMaxSize()
            .padding(12.dp)
            .verticalScroll(rememberScrollState())
    ) {
        IconButton(
            onClick = { onBackClick() },
            modifier = Modifier
                .align(Alignment.Start)
        ) {
            Icon(
                imageVector = Icons.Filled.ArrowBack,
                contentDescription = stringResource(R.string.text_go_to_back)
            )
        }
        AsyncImage(
            model = imageUrl,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(200.dp)
                .padding(16.dp)
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .background(Brush.verticalGradient(colorStops = colorGradients))
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(
                text = name,
                color = MaterialTheme.colorScheme.primary,
                style = MaterialTheme.typography.titleLarge.copy(
                    fontWeight = FontWeight.Bold,
                ),
            )
            Text(
                text = type,
                style = MaterialTheme.typography.titleMedium,
            )
            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 32.dp)
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(painterResource(R.drawable.ic_attack), contentDescription = null)
                    Text(text = stringResource(R.string.text_attack))
                    Text(text = attack.toString())
                }
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(painterResource(R.drawable.ic_shield), contentDescription = null)
                    Text(text = stringResource(R.string.text_defense))
                    Text(text = defense.toString())
                }
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(painterResource(R.drawable.ic_speed), contentDescription = null)
                    Text(text = stringResource(R.string.text_speed))
                    Text(text = speed.toString())
                }
            }
            Text(
                text = description,
                style = MaterialTheme.typography.bodyLarge,
            )
        }
    }

}