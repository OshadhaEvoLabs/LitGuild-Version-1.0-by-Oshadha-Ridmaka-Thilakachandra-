package com.example.data.repository

import com.example.data.model.ContextQuestionItem
import com.example.data.model.EssayPromptItem
import com.example.data.model.GoldenQuote
import com.example.data.model.LiteraryGenre
import com.example.data.model.LiteraryWork

object AnthologyRepository {
    val allWorks: List<LiteraryWork> by lazy {
        PoetryData.poems + ProseData.proseWorks + DramaNovelData.dramaAndNovels
    }

    fun getWorkById(id: String): LiteraryWork? {
        return allWorks.find { it.id == id }
    }

    fun getWorksByGenre(genre: LiteraryGenre): List<LiteraryWork> {
        return allWorks.filter { it.genre == genre }
    }

    fun getAllContextQuestions(): List<ContextQuestionItem> {
        return allWorks.flatMap { it.contextQuestions }
    }

    fun getAllEssayPrompts(): List<EssayPromptItem> {
        return allWorks.flatMap { it.essayPrompts }
    }

    fun getAllGoldenQuotes(): List<Pair<LiteraryWork, GoldenQuote>> {
        return allWorks.flatMap { work ->
            work.goldenQuotes.map { quote -> Pair(work, quote) }
        }
    }
}
