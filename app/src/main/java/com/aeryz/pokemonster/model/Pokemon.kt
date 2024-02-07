package com.aeryz.pokemonster.model

data class Pokemon(
    val id: Int,
    val name: String,
    val type: String,
    val imageUrl: String,
    val description: String,
    val attack: Int,
    val defense: Int,
    val speed: Int
)
