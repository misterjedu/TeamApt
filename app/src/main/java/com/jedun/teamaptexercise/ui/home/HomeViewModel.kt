package com.jedun.teamaptexercise.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jedun.teamaptexercise.ui.model.Savings
import com.jedun.teamaptexercise.utils.notifyObserver

class HomeViewModel : ViewModel() {

    private val _balance: MutableLiveData<MutableList<Savings>> = MutableLiveData(mutableListOf())
    val observableBalance: LiveData<MutableList<Savings>> = _balance

    private var actionList: MutableList<Savings> = mutableListOf(
        Savings("Mummy", "Pocket money", 50),
        Savings("Daddy", "Hospital money", 170),
        Savings("Fred", "Buy a course", 340),
        Savings("Alozie", "Salary Bonus", 90),
        Savings("Bukola", "Loan payback", 250),
        Savings("Uncle Tom", "Book money", 100)
    )

    init {
        _balance.value?.add(actionList[0])
        actionList.removeAt(0)
    }

    fun addRequest() {
        if (actionList.isNotEmpty()) {
            val randomPickIndex = (actionList.indices).random()
            _balance.value?.add(0, actionList[randomPickIndex])
            _balance.notifyObserver()
            actionList.removeAt(randomPickIndex)
        }
    }


}