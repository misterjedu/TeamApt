package com.jedun.teamaptexercise.ui.home.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.jedun.teamaptexercise.databinding.ItemLayoutActionsBinding
import com.jedun.teamaptexercise.ui.model.Savings

class SavingsListAdapter : ListAdapter<Savings, SavingsViewHolder>(SavingsDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SavingsViewHolder {
        val binding =
            ItemLayoutActionsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SavingsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SavingsViewHolder, position: Int) {
        val currentItem = getItem(position)
        if (currentItem != null)
            holder.bind(currentItem)
    }

}

