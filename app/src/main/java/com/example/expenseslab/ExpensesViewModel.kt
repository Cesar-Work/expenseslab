package com.example.expenseslab

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class ExpensesViewModel(app: Application) : AndroidViewModel(app) {

    private val repo: ExpenseRepository

    val expenses = run {
        val dao = AppDatabase.getInstance(app).expenseDao()
        ExpenseRepository(dao).also { repo = it }.expenses
            .stateIn(viewModelScope, SharingStarted.Lazily, emptyList())
    }

    fun addExpense(
        title: String,
        amount: Double,
        category: String,
        account: String,
        notes: String?
    ) {
        viewModelScope.launch {
            repo.upsert(
                Expense(
                    title = title,
                    amount = amount,
                    category = category,
                    account = account,
                    timestamp = System.currentTimeMillis(),
                    notes = notes
                )
            )
        }
    }

    fun delete(expense: Expense) {
        viewModelScope.launch { repo.delete(expense) }
    }

    fun clearAll() {
        viewModelScope.launch { repo.clearAll() }
    }
}
