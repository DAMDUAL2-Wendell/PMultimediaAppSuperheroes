package com.example.appsuperheroes.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Superheroe (
    @DrawableRes val imaxeId: Int,
    @StringRes val title: Int,
    @StringRes val description: Int,
    @StringRes val extra: Int,
)