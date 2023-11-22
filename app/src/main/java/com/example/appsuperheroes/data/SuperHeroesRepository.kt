package com.example.appsuperheroes.data

import com.example.appsuperheroes.R
import com.example.appsuperheroes.model.Superheroe

object SuperHeroesRepository {
    val superHeroesList = listOf<Superheroe>(
        Superheroe(imaxeId = R.drawable.android_superhero1, nome = R.string.hero1, about = R.string.description1),
        Superheroe(imaxeId = R.drawable.android_superhero2,nome=R.string.hero2,about=R.string.description2),
        Superheroe(imaxeId = R.drawable.android_superhero3,nome=R.string.hero3,about=R.string.description3),
        Superheroe(imaxeId = R.drawable.android_superhero4,nome=R.string.hero4,about=R.string.description4),
        Superheroe(imaxeId = R.drawable.android_superhero5,nome=R.string.hero5,about=R.string.description5),
        Superheroe(imaxeId = R.drawable.android_superhero6,nome=R.string.hero6,about=R.string.description6)
    )
}