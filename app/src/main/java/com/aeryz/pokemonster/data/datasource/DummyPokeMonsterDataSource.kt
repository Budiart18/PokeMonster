package com.aeryz.pokemonster.data.datasource

import com.aeryz.pokemonster.model.Pokemon

interface DummyPokeMonsterDataSource {
    fun getPokemonData(): List<Pokemon>
}

class DummyPokeMonsterDataSourceImpl : DummyPokeMonsterDataSource {
    override fun getPokemonData(): List<Pokemon> {
        return mutableListOf(
            Pokemon(
                id = 1,
                name = "Bulbasaur",
                type = "Grass",
                imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/1.png",
                description = "Bulbasaur can be seen napping in bright sunlight.",
                attack = 49,
                defense = 49,
                speed = 45
            ),
            Pokemon(
                id = 2,
                name = "Charmander",
                type = "Fire",
                imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/4.png",
                description = "The flame on its tail indicates Charmander's life force. If it is healthy, the flame burns brightly.",
                attack = 52,
                defense = 43,
                speed = 65
            ),
            Pokemon(
                id = 3,
                name = "Squirtle",
                type = "Water",
                imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/7.png",
                description = "Squirtle's shell is not merely used for protection. The shell's rounded shape and the grooves on its surface help minimize resistance in water, enabling this Pokémon to swim at high speeds.",
                attack = 48,
                defense = 65,
                speed = 43
            ),
            Pokemon(
                id = 4,
                name = "Pikachu",
                type = "Electric",
                imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/25.png",
                description = "Pikachu that can generate powerful electricity have cheek sacs that are extra soft and super stretchy.",
                attack = 55,
                defense = 40,
                speed = 90
            ),
            Pokemon(
                id = 5,
                name = "Jigglypuff",
                type = "Normal",
                imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/39.png",
                description = "Jigglypuff's vocal cords can freely adjust the wavelength of its voice. This Pokémon uses this ability to sing at precisely the right wavelength to make its foes most drowsy.",
                attack = 45,
                defense = 20,
                speed = 20
            ),
            Pokemon(
                id = 6,
                name = "Gyarados",
                type = "Water",
                imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/130.png",
                description = "Once Gyarados goes on a rampage, its ferociously violent blood doesn't calm until it has burned everything down. There are records of this Pokémon's rampages lasting a whole month.",
                attack = 125,
                defense = 79,
                speed = 81
            ),
            Pokemon(
                id = 7,
                name = "Snorlax",
                type = "Normal",
                imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/143.png",
                description = "Snorlax's typical day consists of nothing more than eating and sleeping. It is such a docile Pokémon that there are children who use its expansive belly as a place to play.",
                attack = 110,
                defense = 65,
                speed = 30
            ),
            Pokemon(
                id = 8,
                name = "Mewtwo",
                type = "Psychic",
                imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/150.png",
                description = "Mewtwo is a Pokémon that was created by genetic manipulation. However, even though the scientific power of humans created this Pokémon's body, they failed to endow Mewtwo with a compassionate heart.",
                attack = 110,
                defense = 90,
                speed = 130
            ),
            Pokemon(
                id = 9,
                name = "Mew",
                type = "Psychic",
                imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/151.png",
                description = "Mew is said to possess the genetic composition of all Pokémon. It is capable of making itself invisible at will, so it entirely avoids notice even if it approaches people.",
                attack = 100,
                defense = 100,
                speed = 100
            ),
            Pokemon(
                id = 10,
                name = "Lugia",
                type = "Psychic",
                imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/249.png",
                description = "Lugia's wings pack devastating power—a light fluttering of its wings can blow apart regular houses. As a result, this Pokémon chooses to live out of sight deep under the sea.",
                attack = 90,
                defense = 130,
                speed = 110
            ),
            Pokemon(
                id = 11,
                name = "Ho-Oh",
                type = "Fire",
                imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/250.png",
                description = "Ho-Oh's feathers glow in seven colors depending on the angle at which they are struck by light. These feathers are said to bring happiness to the bearers. This Pokémon is said to live at the foot of a rainbow.",
                attack = 130,
                defense = 90,
                speed = 110
            ),
            Pokemon(
                id = 12,
                name = "Celebi",
                type = "Psychic",
                imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/251.png",
                description = "Celebi has the power to travel through time, and thus wanders from one age to the next.",
                attack = 100,
                defense = 100,
                speed = 100
            ),
            Pokemon(
                id = 13,
                name = "Rayquaza",
                type = "Dragon",
                imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/384.png",
                description = "Rayquaza is said to have lived for hundreds of millions of years. Legends remain of how it put to rest the clash between Kyogre and Groudon.",
                attack = 150,
                defense = 90,
                speed = 95
            ),
            Pokemon(
                id = 14,
                name = "Jirachi",
                type = "Steel",
                imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/385.png",
                description = "Jirachi will awaken from its sleep of a thousand years if you sing to it in a voice of purity.",
                attack = 100,
                defense = 100,
                speed = 100
            ),
            Pokemon(
                id = 15,
                name = "Deoxys",
                type = "Psychic",
                imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/386.png",
                description = "Deoxys emerged from a virus that came from space. It is highly intelligent and wields psychokinetic powers.",
                attack = 150,
                defense = 50,
                speed = 150
            ),
            Pokemon(
                id = 16,
                name = "Piplup",
                type = "Water",
                imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/393.png",
                description = "Because it is very proud, it hates accepting food from people. Its thick down guards it from cold.",
                attack = 51,
                defense = 53,
                speed = 40
            ),
            Pokemon(
                id = 17,
                name = "Lucario",
                type = "Fighting",
                imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/448.png",
                description = "By reading the auras of all things, it can tell how others are feeling from over half a mile away.",
                attack = 110,
                defense = 70,
                speed = 90
            ),
            Pokemon(
                id = 18,
                name = "Garchomp",
                type = "Dragon",
                imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/445.png",
                description = "When it folds up its body and extends its wings, it looks like a jet plane. It flies at sonic speed.",
                attack = 130,
                defense = 95,
                speed = 102
            ),
            Pokemon(
                id = 19,
                name = "Togekiss",
                type = "Fairy",
                imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/468.png",
                description = "As everyone knows, it visits peaceful regions, bringing them gifts of kindness and sweet blessings.",
                attack = 50,
                defense = 95,
                speed = 80
            ),
            Pokemon(
                id = 20,
                name = "Dialga",
                type = "Steel",
                imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/483.png",
                description = "A legendary Pokémon of Sinnoh. It is said that time flows when Dialga's heart beats.",
                attack = 120,
                defense = 120,
                speed = 90
            )
        )
    }
}