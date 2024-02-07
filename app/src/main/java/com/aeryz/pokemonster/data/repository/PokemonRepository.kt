package com.aeryz.pokemonster.data.repository

import com.aeryz.pokemonster.data.datasource.DummyPokeMonsterDataSource
import com.aeryz.pokemonster.model.Pokemon
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

interface PokemonRepository {
    fun getPokemonData(query: String): Flow<List<Pokemon>>
    fun getPokemonDetail(pokemonId: Int): Pokemon
}

class PokemonRepositoryImpl(
    private val dataSource: DummyPokeMonsterDataSource
) : PokemonRepository {

    override fun getPokemonData(query: String): Flow<List<Pokemon>> {
        return flowOf(dataSource.getPokemonData().filter {
            it.name.contains(query, ignoreCase = true)
        })
    }

    override fun getPokemonDetail(pokemonId: Int): Pokemon {
        return dataSource.getPokemonData().first {
            it.id == pokemonId
        }
    }
}