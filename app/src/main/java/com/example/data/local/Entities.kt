package com.example.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "saved_essays")
data class SavedEssayEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val workTitle: String,
    val promptTitle: String,
    val essayPrompt: String,
    val studentEssayText: String,
    val score: Int?,
    val maxScore: Int = 20,
    val gradeBand: String?,
    val aiFeedbackJson: String?,
    val timestamp: Long = System.currentTimeMillis()
)

@Entity(tableName = "context_practices")
data class SavedContextPracticeEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val workTitle: String,
    val quoteExtract: String,
    val answerA: String,
    val answerB: String,
    val answerC: String,
    val answerD: String,
    val totalScore: Int?,
    val aiFeedbackSummary: String?,
    val timestamp: Long = System.currentTimeMillis()
)

@Entity(tableName = "bookmarked_quotes")
data class SavedQuoteBookmarkEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val workTitle: String,
    val author: String,
    val quote: String,
    val significance: String,
    val userNotes: String = "",
    val timestamp: Long = System.currentTimeMillis()
)
