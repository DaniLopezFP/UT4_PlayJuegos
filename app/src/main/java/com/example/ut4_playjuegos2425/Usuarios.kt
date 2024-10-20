package com.example.ut4_playjuegos2425

import androidx.annotation.DrawableRes

data class Users(
    var nombre: String,
    var puntuacion: Int,
    @DrawableRes var photo: Int
)
