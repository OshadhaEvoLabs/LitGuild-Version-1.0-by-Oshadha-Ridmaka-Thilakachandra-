package com.example.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Grading
import androidx.compose.material.icons.automirrored.filled.MenuBook
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.data.repository.AnthologyRepository
import com.example.ui.viewmodel.LitViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EssayGuildScreen(
    viewModel: LitViewModel,
    modifier: Modifier = Modifier
) {
    val selectedPrompt by viewModel.selectedPrompt.collectAsState()
    val essayText by viewModel.studentEssayText.collectAsState()
    val feedback by viewModel.essayFeedback.collectAsState()
    val isGrading by viewModel.isGradingEssay.collectAsState()

    var showPeelGuide by remember { mutableStateOf(false) }
    var showPromptDropdown by remember { mutableStateOf(false) }
    var showModelOutline by remember { mutableStateOf(false) }

    val allPrompts = remember { AnthologyRepository.getAllEssayPrompts() }

    val wordCount = remember(essayText) {
        if (essayText.isBlank()) 0 else essayText.trim().split("\\s+".toRegex()).size
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text(
                            text = "Essay Writing Guild",
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "P.E.E.L Strategy & 20-Mark AI Evaluation",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                },
                actions = {
                    IconButton(
                        onClick = { showPeelGuide = !showPeelGuide },
                        modifier = Modifier.testTag("peel_guide_button")
                    ) {
                        Icon(Icons.Default.School, contentDescription = "PEEL Guide")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surface
                )
            )
        },
        modifier = modifier
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // PEEL Strategy Accordion
            AnimatedVisibility(visible = showPeelGuide) {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.secondaryContainer.copy(alpha = 0.6f)
                    )
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            text = "The P.E.E.L. Formula for O/L Literature Essays",
                            style = MaterialTheme.typography.titleSmall,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.secondary
                        )
                        Spacer(modifier = Modifier.height(6.dp))
                        Text(text = "• Point: Clear topic sentence declaring your analytical argument.")
                        Text(text = "• Evidence: Embedded quote from the text (not a freestanding line).")
                        Text(text = "• Explanation: Deconstruct the quote, naming literary devices (imagery, irony, metaphor, diction).")
                        Text(text = "• Link: Connect back to the overarching thesis and prompt question.")
                    }
                }
            }

            // Prompt Selector Card
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surface
                ),
                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "Exam Essay Prompt",
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.primary,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "${selectedPrompt.workTitle} (${selectedPrompt.genre.displayName})",
                        style = MaterialTheme.typography.labelMedium,
                        fontWeight = FontWeight.SemiBold
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = selectedPrompt.prompt,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        OutlinedButton(
                            onClick = { showPromptDropdown = true },
                            modifier = Modifier.testTag("change_prompt_button")
                        ) {
                            Icon(Icons.AutoMirrored.Filled.MenuBook, contentDescription = null)
                            Spacer(modifier = Modifier.width(6.dp))
                            Text("Switch Question")
                        }

                        OutlinedButton(
                            onClick = { showModelOutline = !showModelOutline },
                            modifier = Modifier.testTag("outline_toggle_button")
                        ) {
                            Icon(
                                if (showModelOutline) Icons.Default.VisibilityOff else Icons.Default.Lightbulb,
                                contentDescription = null
                            )
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(if (showModelOutline) "Hide Outline" else "View Outline")
                        }
                    }

                    // Prompt dropdown menu
                    DropdownMenu(
                        expanded = showPromptDropdown,
                        onDismissRequest = { showPromptDropdown = false }
                    ) {
                        allPrompts.forEach { p ->
                            DropdownMenuItem(
                                text = {
                                    Column {
                                        Text(p.workTitle, fontWeight = FontWeight.Bold)
                                        Text(p.title, style = MaterialTheme.typography.bodySmall)
                                    }
                                },
                                onClick = {
                                    viewModel.selectEssayPrompt(p)
                                    showPromptDropdown = false
                                }
                            )
                        }
                    }
                }
            }

            // Outline Card
            AnimatedVisibility(visible = showModelOutline) {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surfaceVariant
                    )
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            text = "Model Essay Structure & Key Arguments",
                            style = MaterialTheme.typography.titleSmall,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.primary
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        selectedPrompt.keyPoints.forEach { kp ->
                            Text(text = "✔ $kp", style = MaterialTheme.typography.bodySmall)
                            Spacer(modifier = Modifier.height(4.dp))
                        }
                        Spacer(modifier = Modifier.height(6.dp))
                        Text(
                            text = "Sample Body P.E.E.L:",
                            style = MaterialTheme.typography.labelSmall,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = selectedPrompt.peelStructure,
                            style = MaterialTheme.typography.bodySmall,
                            fontStyle = FontStyle.Italic
                        )
                    }
                }
            }

            // Essay Composer Box
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surface
                ),
                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Your Essay Draft",
                            style = MaterialTheme.typography.titleSmall,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "$wordCount words (Target: 250-400)",
                            style = MaterialTheme.typography.labelSmall,
                            color = if (wordCount >= 200) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.outline
                        )
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    OutlinedTextField(
                        value = essayText,
                        onValueChange = { viewModel.studentEssayText.value = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .heightIn(min = 200.dp, max = 400.dp)
                            .testTag("essay_editor_input"),
                        placeholder = {
                            Text("Write your essay here... Introduce your thesis, elaborate with body paragraphs using PEEL, and provide a strong conclusion.")
                        }
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    Button(
                        onClick = { viewModel.gradeStudentEssay() },
                        modifier = Modifier
                            .fillMaxWidth()
                            .testTag("submit_essay_button"),
                        enabled = !isGrading && essayText.isNotBlank()
                    ) {
                        if (isGrading) {
                            CircularProgressIndicator(
                                modifier = Modifier.size(18.dp),
                                color = MaterialTheme.colorScheme.onPrimary,
                                strokeWidth = 2.dp
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text("Examiner Evaluating Essay...")
                        } else {
                            Icon(Icons.AutoMirrored.Filled.Grading, contentDescription = null)
                            Spacer(modifier = Modifier.width(8.dp))
                            Text("Submit for 20-Mark AI Evaluation")
                        }
                    }
                }
            }

            // AI Feedback Results
            AnimatedVisibility(visible = feedback != null) {
                feedback?.let { fb ->
                    ElevatedCard(
                        modifier = Modifier
                            .fillMaxWidth()
                            .testTag("essay_feedback_card"),
                        colors = CardDefaults.elevatedCardColors(
                            containerColor = MaterialTheme.colorScheme.surface
                        )
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Column {
                                    Text(
                                        text = "Official Evaluation",
                                        style = MaterialTheme.typography.titleMedium,
                                        fontWeight = FontWeight.Bold,
                                        color = MaterialTheme.colorScheme.primary
                                    )
                                    Text(
                                        text = "Predicted Grade: ${fb.gradeBand}",
                                        style = MaterialTheme.typography.labelSmall,
                                        fontWeight = FontWeight.Bold,
                                        color = MaterialTheme.colorScheme.secondary
                                    )
                                }
                                Badge(containerColor = MaterialTheme.colorScheme.primary) {
                                    Text(
                                        text = "${fb.score} / ${fb.maxScore}",
                                        modifier = Modifier.padding(6.dp),
                                        style = MaterialTheme.typography.titleMedium,
                                        fontWeight = FontWeight.Bold
                                    )
                                }
                            }

                            Spacer(modifier = Modifier.height(12.dp))

                            // Criteria breakdown
                            Text(
                                text = "Assessment Rubric Breakdown:",
                                style = MaterialTheme.typography.labelMedium,
                                fontWeight = FontWeight.Bold
                            )
                            Text(text = "• Relevance & Thesis: ${fb.contentRelevanceScore} / 5", style = MaterialTheme.typography.bodySmall)
                            Text(text = "• Textual Evidence & Quotes: ${fb.textualEvidenceScore} / 5", style = MaterialTheme.typography.bodySmall)
                            Text(text = "• Analysis of Literary Devices: ${fb.literaryTechniquesScore} / 5", style = MaterialTheme.typography.bodySmall)
                            Text(text = "• Structure & Academic Voice: ${fb.structureAndLanguageScore} / 5", style = MaterialTheme.typography.bodySmall)

                            Spacer(modifier = Modifier.height(10.dp))
                            Text(
                                text = "Chief Examiner Feedback:",
                                style = MaterialTheme.typography.labelMedium,
                                fontWeight = FontWeight.Bold
                            )
                            Text(text = fb.summaryFeedback, style = MaterialTheme.typography.bodySmall)

                            Spacer(modifier = Modifier.height(10.dp))
                            Text(
                                text = "Strong Points in Your Response:",
                                style = MaterialTheme.typography.labelMedium,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.tertiary
                            )
                            fb.strongPoints.forEach { sp ->
                                Text(text = "✔ $sp", style = MaterialTheme.typography.bodySmall)
                            }

                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                text = "Suggestions for Higher Marks:",
                                style = MaterialTheme.typography.labelMedium,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.error
                            )
                            fb.missingCriticalPoints.forEach { mp ->
                                Text(text = "▲ $mp", style = MaterialTheme.typography.bodySmall)
                            }

                            Spacer(modifier = Modifier.height(12.dp))
                            Card(
                                colors = CardDefaults.cardColors(
                                    containerColor = MaterialTheme.colorScheme.surfaceVariant
                                )
                            ) {
                                Column(modifier = Modifier.padding(12.dp)) {
                                    Text(
                                        text = "Sample High-Scoring Phrasing:",
                                        style = MaterialTheme.typography.labelSmall,
                                        fontWeight = FontWeight.Bold,
                                        color = MaterialTheme.colorScheme.primary
                                    )
                                    Spacer(modifier = Modifier.height(4.dp))
                                    Text(
                                        text = fb.sampleElevatedParagraph,
                                        style = MaterialTheme.typography.bodySmall,
                                        fontStyle = FontStyle.Italic
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
