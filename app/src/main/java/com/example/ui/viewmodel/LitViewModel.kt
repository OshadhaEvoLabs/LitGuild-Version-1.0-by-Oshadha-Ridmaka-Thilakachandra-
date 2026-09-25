package com.example.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.ai.GeminiAiService
import com.example.auth.AuthManager
import com.example.data.local.LitDatabase
import com.example.data.local.SavedContextPracticeEntity
import com.example.data.local.SavedEssayEntity
import com.example.data.local.SavedQuoteBookmarkEntity
import com.example.data.model.*
import com.example.data.repository.AnthologyRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

data class ChatMessage(
    val id: String = java.util.UUID.randomUUID().toString(),
    val sender: String, // "user" or "ai"
    val text: String,
    val timestamp: Long = System.currentTimeMillis()
)

class LitViewModel(application: Application) : AndroidViewModel(application) {
    private val db = LitDatabase.getDatabase(application)
    private val essayDao = db.savedEssayDao()
    private val contextDao = db.contextPracticeDao()
    private val bookmarkDao = db.bookmarkedQuoteDao()
    private val aiService = GeminiAiService()
    private val authManager = AuthManager(application)

    // Auth State
    private val _currentUser = MutableStateFlow<UserProfile?>(null)
    val currentUser: StateFlow<UserProfile?> = _currentUser.asStateFlow()

    private val _isAuthenticating = MutableStateFlow(false)
    val isAuthenticating: StateFlow<Boolean> = _isAuthenticating.asStateFlow()

    private val _authError = MutableStateFlow<String?>(null)
    val authError: StateFlow<String?> = _authError.asStateFlow()

    val allWorks: List<LiteraryWork> = AnthologyRepository.allWorks

    // Room Database Flows
    val savedEssays: StateFlow<List<SavedEssayEntity>> = essayDao.getAllEssays()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    val savedPractices: StateFlow<List<SavedContextPracticeEntity>> = contextDao.getAllPractices()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    val bookmarkedQuotes: StateFlow<List<SavedQuoteBookmarkEntity>> = bookmarkDao.getAllBookmarks()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    // Library State
    private val _selectedGenre = MutableStateFlow<LiteraryGenre?>(null)
    val selectedGenre: StateFlow<LiteraryGenre?> = _selectedGenre.asStateFlow()

    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery.asStateFlow()

    private val _selectedWork = MutableStateFlow<LiteraryWork>(AnthologyRepository.allWorks.first())
    val selectedWork: StateFlow<LiteraryWork> = _selectedWork.asStateFlow()

    // Context Practice State
    private val allContextQuestions = AnthologyRepository.getAllContextQuestions()
    private val _currentContextQuestion = MutableStateFlow(allContextQuestions.first())
    val currentContextQuestion: StateFlow<ContextQuestionItem> = _currentContextQuestion.asStateFlow()

    val answerA = MutableStateFlow("")
    val answerB = MutableStateFlow("")
    val answerC = MutableStateFlow("")
    val answerD = MutableStateFlow("")

    private val _contextFeedback = MutableStateFlow<ContextAiFeedback?>(null)
    val contextFeedback: StateFlow<ContextAiFeedback?> = _contextFeedback.asStateFlow()

    private val _isEvaluatingContext = MutableStateFlow(false)
    val isEvaluatingContext: StateFlow<Boolean> = _isEvaluatingContext.asStateFlow()

    // Essay Guild State
    private val allEssayPrompts = AnthologyRepository.getAllEssayPrompts()
    private val _selectedPrompt = MutableStateFlow(allEssayPrompts.first())
    val selectedPrompt: StateFlow<EssayPromptItem> = _selectedPrompt.asStateFlow()

    val studentEssayText = MutableStateFlow("")

    private val _essayFeedback = MutableStateFlow<EssayAiFeedback?>(null)
    val essayFeedback: StateFlow<EssayAiFeedback?> = _essayFeedback.asStateFlow()

    private val _isGradingEssay = MutableStateFlow(false)
    val isGradingEssay: StateFlow<Boolean> = _isGradingEssay.asStateFlow()

    // AI Tutor Chat State
    private val _chatMessages = MutableStateFlow<List<ChatMessage>>(
        listOf(
            ChatMessage(
                sender = "ai",
                text = "Welcome to LitGuide AI! I am your companion for the G.C.E. (O/L) English Literature examination. You can ask me to analyze themes, explain quotations, evaluate essay ideas, or clarify character conflicts in any of our prescribed texts."
            )
        )
    )
    val chatMessages: StateFlow<List<ChatMessage>> = _chatMessages.asStateFlow()

    private val _isAiThinking = MutableStateFlow(false)
    val isAiThinking: StateFlow<Boolean> = _isAiThinking.asStateFlow()

    // UI actions
    fun setGenreFilter(genre: LiteraryGenre?) {
        _selectedGenre.value = genre
    }

    fun setSearchQuery(query: String) {
        _searchQuery.value = query
    }

    fun selectWork(work: LiteraryWork) {
        _selectedWork.value = work
    }

    fun selectContextQuestion(question: ContextQuestionItem) {
        _currentContextQuestion.value = question
        answerA.value = ""
        answerB.value = ""
        answerC.value = ""
        answerD.value = ""
        _contextFeedback.value = null
    }

    fun nextRandomContextQuestion() {
        val next = allContextQuestions.random()
        selectContextQuestion(next)
    }

    fun evaluateContextPractice() {
        val q = _currentContextQuestion.value
        _isEvaluatingContext.value = true
        viewModelScope.launch {
            val feedback = aiService.evaluateContextAnswers(
                workTitle = q.workTitle,
                quote = q.extractQuote,
                answerA = answerA.value,
                answerB = answerB.value,
                answerC = answerC.value,
                answerD = answerD.value
            )
            _contextFeedback.value = feedback
            _isEvaluatingContext.value = false

            // Save to database
            contextDao.insertPractice(
                SavedContextPracticeEntity(
                    workTitle = q.workTitle,
                    quoteExtract = q.extractQuote,
                    answerA = answerA.value,
                    answerB = answerB.value,
                    answerC = answerC.value,
                    answerD = answerD.value,
                    totalScore = feedback.totalScore,
                    aiFeedbackSummary = feedback.strengths
                )
            )
        }
    }

    fun selectEssayPrompt(prompt: EssayPromptItem) {
        _selectedPrompt.value = prompt
        _essayFeedback.value = null
    }

    fun gradeStudentEssay() {
        val prompt = _selectedPrompt.value
        val text = studentEssayText.value
        if (text.isBlank()) return

        _isGradingEssay.value = true
        viewModelScope.launch {
            val feedback = aiService.evaluateEssay(
                workTitle = prompt.workTitle,
                prompt = prompt.prompt,
                essayText = text
            )
            _essayFeedback.value = feedback
            _isGradingEssay.value = false

            // Save to Room DB
            essayDao.insertEssay(
                SavedEssayEntity(
                    workTitle = prompt.workTitle,
                    promptTitle = prompt.title,
                    essayPrompt = prompt.prompt,
                    studentEssayText = text,
                    score = feedback.score,
                    gradeBand = feedback.gradeBand,
                    aiFeedbackJson = feedback.summaryFeedback
                )
            )
        }
    }

    fun deleteEssay(id: Long) {
        viewModelScope.launch {
            essayDao.deleteEssayById(id)
        }
    }

    fun toggleBookmarkQuote(workTitle: String, author: String, quote: String, significance: String) {
        viewModelScope.launch {
            val exists = bookmarkDao.isBookmarked(quote)
            if (exists) {
                bookmarkDao.deleteBookmarkByQuote(quote)
            } else {
                bookmarkDao.insertBookmark(
                    SavedQuoteBookmarkEntity(
                        workTitle = workTitle,
                        author = author,
                        quote = quote,
                        significance = significance
                    )
                )
            }
        }
    }

    fun sendTutorMessage(userText: String) {
        if (userText.isBlank()) return
        val currentContext = _selectedWork.value.title

        val newMsg = ChatMessage(sender = "user", text = userText)
        _chatMessages.value = _chatMessages.value + newMsg
        _isAiThinking.value = true

        viewModelScope.launch {
            val reply = aiService.askLiteratureTutor(userText, currentContext)
            _chatMessages.value = _chatMessages.value + ChatMessage(sender = "ai", text = reply)
            _isAiThinking.value = false
        }
    }

    fun signInWithGoogle() {
        _isAuthenticating.value = true
        _authError.value = null
        viewModelScope.launch {
            val res = authManager.signInWithGoogle()
            if (res.isSuccess) {
                _currentUser.value = res.getOrNull()
            } else {
                _authError.value = res.exceptionOrNull()?.message ?: "Failed to sign in with Google"
            }
            _isAuthenticating.value = false
        }
    }

    fun signInWithFacebook() {
        _isAuthenticating.value = true
        _authError.value = null
        viewModelScope.launch {
            val res = authManager.signInWithFacebook()
            if (res.isSuccess) {
                _currentUser.value = res.getOrNull()
            } else {
                _authError.value = res.exceptionOrNull()?.message ?: "Failed to sign in with Facebook"
            }
            _isAuthenticating.value = false
        }
    }

    fun signInWithEmail(name: String, email: String) {
        if (!email.contains("@") || !email.contains(".")) {
            _authError.value = "Please enter a valid email address."
            return
        }
        _currentUser.value = authManager.signInWithEmail(name, email)
        _authError.value = null
    }

    fun continueAsGuest() {
        _currentUser.value = authManager.continueAsGuest()
        _authError.value = null
    }

    fun signOut() {
        _currentUser.value = null
    }

    fun clearAuthError() {
        _authError.value = null
    }
}
