package com.example.data.model

enum class LiteraryGenre(val displayName: String) {
    POETRY("Poetry"),
    PROSE("Prose"),
    DRAMA("Drama"),
    NOVEL("Novel")
}

enum class ThemeCategory(val displayName: String) {
    NATURE("Nature"),
    CONFLICT("Conflict"),
    SOCIETY("Society"),
    LIFE("Life"),
    HUMOUR("Humour"),
    CRICKET_RESILIENCE("Courage & Heroism"),
    TRAGEDY_LOSS("Loss & Bereavement"),
    GREED_LOVE("Love vs Materialism"),
    FARCE_SATIRE("Farce & Human Folly"),
    CLASS_IDENTITY("Social Class & Identity")
}

data class TechniqueAnalysis(
    val deviceName: String,
    val quoteExample: String,
    val explanation: String
)

data class CharacterProfile(
    val name: String,
    val role: String,
    val traits: List<String>,
    val analysis: String
)

data class GoldenQuote(
    val quote: String,
    val speakerOrContext: String,
    val analyticalSignificance: String,
    val themeTags: List<String>
)

data class ContextQuestionItem(
    val id: String,
    val workTitle: String,
    val author: String,
    val extractQuote: String,
    val questionA: String = "Name the work from which these lines are taken and who wrote them.",
    val questionB: String,
    val questionC: String,
    val questionD: String,
    val modelAnswerA: String,
    val modelAnswerB: String,
    val modelAnswerC: String,
    val modelAnswerD: String,
    val marksScheme: String = "Total: 5 Marks (1 + 1 + 1 + 2)"
)

data class EssayPromptItem(
    val id: String,
    val workTitle: String,
    val genre: LiteraryGenre,
    val title: String,
    val prompt: String,
    val keyPoints: List<String>,
    val peelStructure: String,
    val modelEssaySample: String
)

data class LiteraryWork(
    val id: String,
    val title: String,
    val author: String,
    val genre: LiteraryGenre,
    val category: ThemeCategory,
    val grade: Int,
    val term: Int,
    val fullTextOrExcerpt: String,
    val summary: String,
    val contextBackground: String,
    val keyThemes: List<String>,
    val techniques: List<TechniqueAnalysis>,
    val characters: List<CharacterProfile>,
    val goldenQuotes: List<GoldenQuote>,
    val contextQuestions: List<ContextQuestionItem>,
    val essayPrompts: List<EssayPromptItem>
)

data class ContextAiFeedback(
    val scoreA: Int,
    val scoreB: Int,
    val scoreC: Int,
    val scoreD: Int,
    val totalScore: Int,
    val maxScore: Int = 5,
    val strengths: String,
    val areasForImprovement: String,
    val examinerTips: String,
    val elevatedAnswerSuggestions: String
)

data class EssayAiFeedback(
    val score: Int,
    val maxScore: Int = 20,
    val gradeBand: String, // e.g., "A (Distinction)", "B (Credit)", "C", "S"
    val contentRelevanceScore: Int, // /5
    val textualEvidenceScore: Int, // /5
    val literaryTechniquesScore: Int, // /5
    val structureAndLanguageScore: Int, // /5
    val summaryFeedback: String,
    val strongPoints: List<String>,
    val missingCriticalPoints: List<String>,
    val sampleElevatedParagraph: String
)
