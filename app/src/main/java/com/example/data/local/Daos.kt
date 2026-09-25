package com.example.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface SavedEssayDao {
    @Query("SELECT * FROM saved_essays ORDER BY timestamp DESC")
    fun getAllEssays(): Flow<List<SavedEssayEntity>>

    @Query("SELECT * FROM saved_essays WHERE id = :id LIMIT 1")
    suspend fun getEssayById(id: Long): SavedEssayEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertEssay(essay: SavedEssayEntity): Long

    @Update
    suspend fun updateEssay(essay: SavedEssayEntity)

    @Query("DELETE FROM saved_essays WHERE id = :id")
    suspend fun deleteEssayById(id: Long)
}

@Dao
interface ContextPracticeDao {
    @Query("SELECT * FROM context_practices ORDER BY timestamp DESC")
    fun getAllPractices(): Flow<List<SavedContextPracticeEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPractice(practice: SavedContextPracticeEntity): Long

    @Query("DELETE FROM context_practices WHERE id = :id")
    suspend fun deletePracticeById(id: Long)
}

@Dao
interface BookmarkedQuoteDao {
    @Query("SELECT * FROM bookmarked_quotes ORDER BY timestamp DESC")
    fun getAllBookmarks(): Flow<List<SavedQuoteBookmarkEntity>>

    @Query("SELECT EXISTS(SELECT 1 FROM bookmarked_quotes WHERE quote = :quote LIMIT 1)")
    suspend fun isBookmarked(quote: String): Boolean

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBookmark(bookmark: SavedQuoteBookmarkEntity): Long

    @Query("DELETE FROM bookmarked_quotes WHERE quote = :quote")
    suspend fun deleteBookmarkByQuote(quote: String)

    @Query("DELETE FROM bookmarked_quotes WHERE id = :id")
    suspend fun deleteBookmarkById(id: Long)
}
