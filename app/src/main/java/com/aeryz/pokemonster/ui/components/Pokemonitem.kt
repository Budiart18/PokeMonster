package com.aeryz.pokemonster.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.aeryz.pokemonster.ui.theme.PokeMonsterTheme

@Composable
fun PokemonItem(
    imageUrl: String,
    name: String,
    type: String,
    modifier: Modifier = Modifier
) {
    val colorGradients = arrayOf(
        0.0f to getBackgroundColorForType(type),
        1f to Color.White
    )
    Card(
        elevation = CardDefaults.cardElevation(8.dp),
        shape = MaterialTheme.shapes.medium,
        modifier = modifier
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .background(Brush.verticalGradient(colorStops = colorGradients))
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            AsyncImage(
                model = imageUrl,
                contentDescription = null,
                modifier = Modifier
                    .size(100.dp)
            )
            Text(
                text = name,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}

@Preview(showBackground = true, device = Devices.PIXEL_3A)
@Composable
fun PokemonItemPreview() {
    PokeMonsterTheme {
        PokemonItem(
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/1.png",
            name = "Bulbasaur",
            type = "Grass"
        )
    }
}

fun getBackgroundColorForType(type: String): Color {
    return when (type.lowercase()) {
        "grass" -> Color.Green
        "fire" -> Color.Red
        "water" -> Color.Blue
        "electric" -> Color.Yellow
        "normal" -> Color.Gray
        else -> Color.Gray
    }
}