package com.example.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.ui.viewmodel.LitViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContextPracticeScreen(
    viewModel: LitViewModel,
    modifier: Modifier = Modifier
) {
    val currentQuestion by viewModel.currentContextQuestion.collectAsState()
    val answerA by viewModel.answerA.collectAsState()
    val answerB by viewModel.answerB.collectAsState()
    val answerC by viewModel.answerC.collectAsState()
    val answerD by viewModel.answerD.collectAsState()
    val feedback by viewModel.contextFeedback.collectAsState()
    val isEvaluating by viewModel.isEvaluatingContext.collectAsState()

    var showModelAnswer by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text(
                            text = "Context Question Arena",
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "Section A: 5-Mark Analysis Practice",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                },
                actions = {
                    IconButton(
                        onClick = { viewModel.nextRandomContextQuestion() },
                        modifier = Modifier.testTag("random_context_button")
                    ) {
                        Icon(Icons.Default.Shuffle, contentDescription = "Random Question")
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
            // Text Extract Card
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.4f)
                ),
                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = currentQuestion.workTitle,
                            style = MaterialTheme.typography.labelMedium,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.primary
                        )
                        Text(
                            text = currentQuestion.marksScheme,
                            style = MaterialTheme.typography.labelSmall,
                            color = MaterialTheme.colorScheme.secondary
                        )
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "\"${currentQuestion.extractQuote}\"",
                        style = MaterialTheme.typography.bodyLarge,
                        fontStyle = FontStyle.Italic,
                        fontWeight = FontWeight.Medium,
                        lineHeight = MaterialTheme.typography.bodyLarge.lineHeight
                    )
                }
            }

            // Question A
            OutlinedCard(modifier = Modifier.fillMaxWidth()) {
                Column(modifier = Modifier.padding(12.dp)) {
                    Text(
                        text = "(a) ${currentQuestion.questionA}",
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    OutlinedTextField(
                        value = answerA,
                        onValueChange = { viewModel.answerA.value = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .testTag("context_input_a"),
                        placeholder = { Text("e.g. Taken from 'War is Kind' by Stephen Crane...") },
                        maxLines = 2
                    )
                }
            }

            // Question B
            OutlinedCard(modifier = Modifier.fillMaxWidth()) {
                Column(modifier = Modifier.padding(12.dp)) {
                    Text(
                        text = "(b) ${currentQuestion.questionB}",
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    OutlinedTextField(
                        value = answerB,
                        onValueChange = { viewModel.answerB.value = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .testTag("context_input_b"),
                        placeholder = { Text("Identify speaker, listener, and situation...") },
                        maxLines = 3
                    )
                }
            }

            // Question C
            OutlinedCard(modifier = Modifier.fillMaxWidth()) {
                Column(modifier = Modifier.padding(12.dp)) {
                    Text(
                        text = "(c) ${currentQuestion.questionC}",
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    OutlinedTextField(
                        value = answerC,
                        onValueChange = { viewModel.answerC.value = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .testTag("context_input_c"),
                        placeholder = { Text("Explain literary device, meaning, or tone...") },
                        maxLines = 3
                    )
                }
            }

            // Question D
            OutlinedCard(modifier = Modifier.fillMaxWidth()) {
                Column(modifier = Modifier.padding(12.dp)) {
                    Text(
                        text = "(d) ${currentQuestion.questionD}",
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    OutlinedTextField(
                        value = answerD,
                        onValueChange = { viewModel.answerD.value = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .testTag("context_input_d"),
                        placeholder = { Text("Explain deeper thematic significance and context...") },
                        minLines = 3,
                        maxLines = 6
                    )
                }
            }

            // Action Buttons
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Button(
                    onClick = { viewModel.evaluateContextPractice() },
                    modifier = Modifier
                        .weight(1f)
                        .testTag("context_evaluate_button"),
                    enabled = !isEvaluating
                ) {
                    if (isEvaluating) {
                        CircularProgressIndicator(
                            modifier = Modifier.size(18.dp),
                            color = MaterialTheme.colorScheme.onPrimary,
                            strokeWidth = 2.dp
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("AI Grading...")
                    } else {
                        Icon(Icons.Default.AutoAwesome, contentDescription = null)
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("AI Grade & Feedback")
                    }
                }

                OutlinedButton(
                    onClick = { showModelAnswer = !showModelAnswer },
                    modifier = Modifier.testTag("context_model_answer_toggle")
                ) {
                    Icon(
                        if (showModelAnswer) Icons.Default.VisibilityOff else Icons.Default.Visibility,
                        contentDescription = null
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(if (showModelAnswer) "Hide" else "Model Answer")
                }
            }

            // Feedback Card
            AnimatedVisibility(visible = feedback != null) {
                feedback?.let { fb ->
                    ElevatedCard(
                        modifier = Modifier
                            .fillMaxWidth()
                            .testTag("context_feedback_card"),
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
                                Text(
                                    text = "Examiner's Assessment",
                                    style = MaterialTheme.typography.titleMedium,
                                    fontWeight = FontWeight.Bold,
                                    color = MaterialTheme.colorScheme.primary
                                )
                                Badge(containerColor = MaterialTheme.colorScheme.primary) {
                                    Text(
                                        text = "${fb.totalScore} / ${fb.maxScore} Marks",
                                        modifier = Modifier.padding(4.dp),
                                        style = MaterialTheme.typography.labelLarge,
                                        fontWeight = FontWeight.Bold
                                    )
                                }
                            }

                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                text = "Part Marks: (a) ${fb.scoreA}/1  (b) ${fb.scoreB}/1  (c) ${fb.scoreC}/1  (d) ${fb.scoreD}/2",
                                style = MaterialTheme.typography.labelSmall,
                                fontWeight = FontWeight.SemiBold
                            )

                            Spacer(modifier = Modifier.height(10.dp))
                            Text(
                                text = "Strengths:",
                                style = MaterialTheme.typography.labelMedium,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.tertiary
                            )
                            Text(text = fb.strengths, style = MaterialTheme.typography.bodySmall)

                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                text = "Areas for Improvement:",
                                style = MaterialTheme.typography.labelMedium,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.error
                            )
                            Text(text = fb.areasForImprovement, style = MaterialTheme.typography.bodySmall)

                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                text = "Examiner Tip:",
                                style = MaterialTheme.typography.labelMedium,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.secondary
                            )
                            Text(text = fb.examinerTips, style = MaterialTheme.typography.bodySmall)
                        }
                    }
                }
            }

            // Model Answers Card
            AnimatedVisibility(visible = showModelAnswer) {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surfaceVariant
                    )
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            text = "Official Standard Model Answers",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.secondary
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "(a) ${currentQuestion.modelAnswerA}",
                            style = MaterialTheme.typography.bodySmall
                        )
                        Spacer(modifier = Modifier.height(6.dp))
                        Text(
                            text = "(b) ${currentQuestion.modelAnswerB}",
                            style = MaterialTheme.typography.bodySmall
                        )
                        Spacer(modifier = Modifier.height(6.dp))
                        Text(
                            text = "(c) ${currentQuestion.modelAnswerC}",
                            style = MaterialTheme.typography.bodySmall
                        )
                        Spacer(modifier = Modifier.height(6.dp))
                        Text(
                            text = "(d) ${currentQuestion.modelAnswerD}",
                            style = MaterialTheme.typography.bodySmall
                        )
                    }
                }
            }
        }
    }
}
