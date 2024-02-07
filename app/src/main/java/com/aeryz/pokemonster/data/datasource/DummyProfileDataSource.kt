package com.aeryz.pokemonster.data.datasource

import com.aeryz.pokemonster.model.Profile

interface DummyProfileDataSource {
    fun getProfileData(): Profile
}

class DummyProfileDataSourceImpl : DummyProfileDataSource {
    override fun getProfileData(): Profile {
        return Profile(
            image = "https://dicoding-web-img.sgp1.cdn.digitaloceanspaces.com/small/avatar/dos:501f0f4d78f590163b9e2f3089dfa25720221015081721.png",
            name = "Ragil Budiarto",
            email = "rglbdarto@gmail.com",
        )
    }
}