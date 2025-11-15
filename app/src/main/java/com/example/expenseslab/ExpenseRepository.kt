package com.example.expenseslab

import kotlinx.coroutines.flow.Flow

class ExpenseRepository(private val dao: ExpenseDao) {
    val expenses: Flow<List<Expense>> = dao.getAll()

    suspend fun upsert(expense: Expense) = dao.upsert(expense)
    suspend fun delete(expense: Expense) = dao.delete(expense)
    suspend fun clearAll() = dao.clearAll()
}
