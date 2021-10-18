package com.jedun.teamaptexercise.ui.home.adapters

import androidx.recyclerview.widget.DiffUtil
import com.jedun.teamaptexercise.ui.model.Savings

/**
 * Diff util to help optimize recycler view adapter
 */
class SavingsDiffUtil : DiffUtil.ItemCallback<Savings>() {
    override fun areItemsTheSame(oldItem: Savings, newItem: Savings) =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Savings, newItem: Savings) =
        oldItem == newItem
}