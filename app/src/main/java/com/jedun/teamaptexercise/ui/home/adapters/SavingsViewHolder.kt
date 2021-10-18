package com.jedun.teamaptexercise.ui.home.adapters


import androidx.recyclerview.widget.RecyclerView
import com.jedun.teamaptexercise.databinding.ItemLayoutActionsBinding
import com.jedun.teamaptexercise.ui.model.Savings

class SavingsViewHolder(private val binding: ItemLayoutActionsBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(saving: Savings) {
        binding.apply {
            resources = saving.getResource()
            data = saving
        }
    }
}