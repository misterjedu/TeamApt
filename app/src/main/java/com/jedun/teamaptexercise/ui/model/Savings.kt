package com.jedun.teamaptexercise.ui.model

import com.jedun.teamaptexercise.utils.DataCenter
import java.util.*

data class Savings(
    val from: String,
    val purpose: String,
    val amount: Int,
    val id: String = UUID.randomUUID().toString(),

    ) {
    fun getResource(): ItemCardResource = DataCenter.getRandomCardResource()

}
