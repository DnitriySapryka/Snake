package com.example.snake.domain

import android.content.Context

class RecordManager(private val context: Context) {
    private val sharedPreferences = context.getSharedPreferences("SnakeGame", Context.MODE_PRIVATE)

    fun saveRecord(score: Int) {
        val records = getRecords()
        records.add(score)
        records.sortDescending()
        val editor = sharedPreferences.edit()
        editor.putString("records", records.joinToString(","))
        editor.apply()
    }

    fun getRecords(): MutableList<Int> {
        val recordsString = sharedPreferences.getString("records", "")
        return if (recordsString.isNullOrEmpty()) {
            mutableListOf()
        } else {
            recordsString.split(",").mapNotNull { it.toIntOrNull() }.toMutableList()
        }
    }
}