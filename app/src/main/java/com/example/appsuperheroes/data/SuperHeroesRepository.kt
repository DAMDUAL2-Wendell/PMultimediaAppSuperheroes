package com.example.appsuperheroes.data

import com.example.appsuperheroes.R
import com.example.appsuperheroes.model.Superheroe

object SuperHeroesRepository {
    val superHeroesList = listOf<Superheroe>(
        Superheroe(imaxeId = R.drawable.android_superhero1, nome = R.string.hero1, about = R.string.description1)
    )
}