package com.example.appsuperheroes.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Superheroe (
    @DrawableRes val imaxeId: Int,
    @StringRes val nome: Int,
    val about: Int
)