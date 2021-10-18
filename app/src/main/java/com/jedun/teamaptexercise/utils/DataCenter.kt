package com.jedun.teamaptexercise.utils

import com.jedun.teamaptexercise.R
import com.jedun.teamaptexercise.ui.model.ItemCardResource
import com.jedun.teamaptexercise.ui.model.Savings
import kotlin.random.Random

object DataCenter {

    fun getRandomCardResource(): ItemCardResource {
        val resourceList = listOf(
            ItemCardResource(
                R.color.purple_200,
                R.drawable.ic_baseline_ballot_24,
                R.color.icon_color_one
            ),
            ItemCardResource(
                R.color.card_color_one,
                R.drawable.ic_dashboard_black_24dp,
                R.color.icon_color_two
            ),
            ItemCardResource(
                R.color.card_color_two,
                R.drawable.ic_home_black_24dp,
                R.color.icon_color_three
            )
        )

        return resourceList[(resourceList.indices).random()]
    }
}