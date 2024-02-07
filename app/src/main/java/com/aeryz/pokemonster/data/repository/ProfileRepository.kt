package com.aeryz.pokemonster.data.repository

import com.aeryz.pokemonster.data.datasource.DummyProfileDataSource
import com.aeryz.pokemonster.model.Profile

interface ProfileRepository {
    fun getProfileData(): Profile
}

class ProfileRepositoryImpl(private val dataSource: DummyProfileDataSource) : ProfileRepository {
    override fun getProfileData(): Profile {
        return dataSource.getProfileData()
    }
}