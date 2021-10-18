package com.jedun.teamaptexercise.ui.model

import java.util.*

data class ItemCardResource(
    val cardColorId: Int,
    val iconId: Int,
    val iconColorId: Int,
    val imageId: String = UUID.randomUUID().toString()
)
