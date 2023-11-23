package com.example.appsuperheroes.data

import com.example.appsuperheroes.R
import com.example.appsuperheroes.model.Superheroe

object SuperHeroesRepository {
    val superHeroesList = listOf<Superheroe>(
        Superheroe(imaxeId = R.drawable.android_superhero1, title = R.string.hero1, description = R.string.description1, extra = R.string.extra1),
        Superheroe(imaxeId = R.drawable.android_superhero2,title=R.string.hero2,description=R.string.description2, extra = R.string.extra2),
        Superheroe(imaxeId = R.drawable.android_superhero3,title=R.string.hero3,description=R.string.description3, extra = R.string.extra3),
        Superheroe(imaxeId = R.drawable.android_superhero4,title=R.string.hero4,description=R.string.description4, extra = R.string.extra4),
        Superheroe(imaxeId = R.drawable.android_superhero5,title=R.string.hero5,description=R.string.description5, extra = R.string.extra5),
        Superheroe(imaxeId = R.drawable.android_superhero6,title=R.string.hero6,description=R.string.description6, extra = R.string.extra6)
    )
}