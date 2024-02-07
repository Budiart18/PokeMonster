package com.aeryz.pokemonster.di

import com.aeryz.pokemonster.data.datasource.DummyPokeMonsterDataSource
import com.aeryz.pokemonster.data.datasource.DummyPokeMonsterDataSourceImpl
import com.aeryz.pokemonster.data.datasource.DummyProfileDataSource
import com.aeryz.pokemonster.data.datasource.DummyProfileDataSourceImpl
import com.aeryz.pokemonster.data.repository.PokemonRepository
import com.aeryz.pokemonster.data.repository.PokemonRepositoryImpl
import com.aeryz.pokemonster.data.repository.ProfileRepository
import com.aeryz.pokemonster.data.repository.ProfileRepositoryImpl
import com.aeryz.pokemonster.ui.screen.detail.DetailViewModel
import com.aeryz.pokemonster.ui.screen.home.HomeViewModel
import com.aeryz.pokemonster.ui.screen.profile.ProfileViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

object AppModules {
    fun getModules(): List<Module> = listOf(
        dataSourceModule,
        repositoryModule,
        viewModelModule
    )

    private val dataSourceModule = module {
        single<DummyPokeMonsterDataSource> { DummyPokeMonsterDataSourceImpl() }
        single<DummyProfileDataSource> { DummyProfileDataSourceImpl() }
    }

    private val repositoryModule = module {
        single<PokemonRepository> { PokemonRepositoryImpl(get()) }
        single<ProfileRepository> { ProfileRepositoryImpl(get()) }
    }

    private val viewModelModule = module {
        viewModel { HomeViewModel(get()) }
        viewModel { DetailViewModel(get()) }
        viewModel { ProfileViewModel(get()) }
    }
}