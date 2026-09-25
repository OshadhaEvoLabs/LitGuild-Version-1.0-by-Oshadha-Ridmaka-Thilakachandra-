package com.example.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [
        SavedEssayEntity::class,
        SavedContextPracticeEntity::class,
        SavedQuoteBookmarkEntity::class
    ],
    version = 1,
    exportSchema = false
)
abstract class LitDatabase : RoomDatabase() {
    abstract fun savedEssayDao(): SavedEssayDao
    abstract fun contextPracticeDao(): ContextPracticeDao
    abstract fun bookmarkedQuoteDao(): BookmarkedQuoteDao

    companion object {
        @Volatile
        private var INSTANCE: LitDatabase? = null

        fun getDatabase(context: Context): LitDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    LitDatabase::class.java,
                    "litguide_database"
                )
                    .fallbackToDestructiveMigration(false)
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}
