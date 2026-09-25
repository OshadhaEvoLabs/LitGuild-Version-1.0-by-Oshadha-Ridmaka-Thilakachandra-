package com.example.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RevisionHubScreen(
    viewModel: LitViewModel,
    onOpenAuth: () -> Unit,
    modifier: Modifier = Modifier
) {
    val savedEssays by viewModel.savedEssays.collectAsState()
    val savedPractices by viewModel.savedPractices.collectAsState()
    val bookmarks by viewModel.bookmarkedQuotes.collectAsState()
    val currentUser by viewModel.currentUser.collectAsState()

    var activeTab by remember { mutableStateOf(0) }
    val tabTitles = listOf("Essays (${savedEssays.size})", "Contexts (${savedPractices.size})", "Quotes (${bookmarks.size})", "Syllabus")

    val dateFormat = remember { SimpleDateFormat("MMM dd, yyyy", Locale.getDefault()) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text(
                            text = "Revision & Exam Hub",
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "Track your essays, score history, and bookmarks",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
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
        ) {
            // User Profile Header with Google/Facebook/Email status
            UserProfileHeader(
                user = currentUser,
                onOpenAuth = onOpenAuth,
                onSignOut = { viewModel.signOut() },
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
            )

            ScrollableTabRow(
                selectedTabIndex = activeTab,
                edgePadding = 16.dp
            ) {
                tabTitles.forEachIndexed { idx, title ->
                    Tab(
                        selected = activeTab == idx,
                        onClick = { activeTab = idx },
                        text = { Text(title) },
                        modifier = Modifier.testTag("rev_tab_$idx")
                    )
                }
            }

            when (activeTab) {
                0 -> {
                    // Saved Essays
                    if (savedEssays.isEmpty()) {
                        EmptyStateView(
                            icon = Icons.Default.Description,
                            title = "No Graded Essays Yet",
                            subtitle = "Submit an essay in the Essay Guild to receive AI evaluation and store your progress."
                        )
                    } else {
                        LazyColumn(
                            modifier = Modifier.fillMaxSize(),
                            contentPadding = PaddingValues(16.dp),
                            verticalArrangement = Arrangement.spacedBy(12.dp)
                        ) {
                            items(savedEssays, key = { it.id }) { essay ->
                                Card(
                                    modifier = Modifier.fillMaxWidth(),
                                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
                                ) {
                                    Column(modifier = Modifier.padding(16.dp)) {
                                        Row(
                                            modifier = Modifier.fillMaxWidth(),
                                            horizontalArrangement = Arrangement.SpaceBetween,
                                            verticalAlignment = Alignment.CenterVertically
                                        ) {
                                            Text(
                                                text = essay.workTitle,
                                                style = MaterialTheme.typography.labelMedium,
                                                fontWeight = FontWeight.Bold,
                                                color = MaterialTheme.colorScheme.primary
                                            )
                                            Badge(containerColor = MaterialTheme.colorScheme.primary) {
                                                Text(
                                                    text = "${essay.score ?: 0}/20 (${essay.gradeBand ?: "-"})",
                                                    modifier = Modifier.padding(4.dp),
                                                    style = MaterialTheme.typography.labelSmall,
                                                    fontWeight = FontWeight.Bold
                                                )
                                            }
                                        }

                                        Spacer(modifier = Modifier.height(4.dp))
                                        Text(
                                            text = essay.promptTitle,
                                            style = MaterialTheme.typography.titleSmall,
                                            fontWeight = FontWeight.Bold
                                        )

                                        Spacer(modifier = Modifier.height(6.dp))
                                        Text(
                                            text = essay.studentEssayText.take(140) + "...",
                                            style = MaterialTheme.typography.bodySmall,
                                            color = MaterialTheme.colorScheme.onSurfaceVariant
                                        )

                                        Spacer(modifier = Modifier.height(8.dp))
                                        Row(
                                            modifier = Modifier.fillMaxWidth(),
                                            horizontalArrangement = Arrangement.SpaceBetween,
                                            verticalAlignment = Alignment.CenterVertically
                                        ) {
                                            Text(
                                                text = dateFormat.format(Date(essay.timestamp)),
                                                style = MaterialTheme.typography.labelSmall,
                                                color = MaterialTheme.colorScheme.outline
                                            )
                                            IconButton(
                                                onClick = { viewModel.deleteEssay(essay.id) },
                                                modifier = Modifier.size(24.dp)
                                            ) {
                                                Icon(
                                                    Icons.Default.DeleteOutline,
                                                    contentDescription = "Delete",
                                                    tint = MaterialTheme.colorScheme.error
                                                )
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                1 -> {
                    // Context Practices
                    if (savedPractices.isEmpty()) {
                        EmptyStateView(
                            icon = Icons.Default.Quiz,
                            title = "No Context Practice Records",
                            subtitle = "Practice 4-part context questions in the Context Arena to save your progress."
                        )
                    } else {
                        LazyColumn(
                            modifier = Modifier.fillMaxSize(),
                            contentPadding = PaddingValues(16.dp),
                            verticalArrangement = Arrangement.spacedBy(12.dp)
                        ) {
                            items(savedPractices, key = { it.id }) { prac ->
                                Card(
                                    modifier = Modifier.fillMaxWidth(),
                                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
                                ) {
                                    Column(modifier = Modifier.padding(14.dp)) {
                                        Row(
                                            modifier = Modifier.fillMaxWidth(),
                                            horizontalArrangement = Arrangement.SpaceBetween
                                        ) {
                                            Text(
                                                text = prac.workTitle,
                                                style = MaterialTheme.typography.labelMedium,
                                                fontWeight = FontWeight.Bold,
                                                color = MaterialTheme.colorScheme.primary
                                            )
                                            Text(
                                                text = "${prac.totalScore ?: 0} / 5 Marks",
                                                style = MaterialTheme.typography.labelSmall,
                                                fontWeight = FontWeight.Bold,
                                                color = MaterialTheme.colorScheme.secondary
                                            )
                                        }
                                        Spacer(modifier = Modifier.height(4.dp))
                                        Text(
                                            text = "\"${prac.quoteExtract}\"",
                                            style = MaterialTheme.typography.bodySmall,
                                            fontStyle = FontStyle.Italic
                                        )
                                        Spacer(modifier = Modifier.height(4.dp))
                                        Text(
                                            text = dateFormat.format(Date(prac.timestamp)),
                                            style = MaterialTheme.typography.labelSmall,
                                            color = MaterialTheme.colorScheme.outline
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
                2 -> {
                    // Bookmarked Quotes
                    if (bookmarks.isEmpty()) {
                        EmptyStateView(
                            icon = Icons.Default.BookmarkBorder,
                            title = "No Bookmarked Quotes",
                            subtitle = "Click the bookmark icon next to any quotation in the Library to save it here for rapid revision."
                        )
                    } else {
                        LazyColumn(
                            modifier = Modifier.fillMaxSize(),
                            contentPadding = PaddingValues(16.dp),
                            verticalArrangement = Arrangement.spacedBy(12.dp)
                        ) {
                            items(bookmarks, key = { it.id }) { b ->
                                Card(
                                    modifier = Modifier.fillMaxWidth(),
                                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
                                ) {
                                    Column(modifier = Modifier.padding(14.dp)) {
                                        Text(
                                            text = "\"${b.quote}\"",
                                            style = MaterialTheme.typography.bodyMedium,
                                            fontWeight = FontWeight.SemiBold,
                                            fontStyle = FontStyle.Italic
                                        )
                                        Spacer(modifier = Modifier.height(6.dp))
                                        Text(
                                            text = "— ${b.workTitle} (${b.author})",
                                            style = MaterialTheme.typography.labelSmall,
                                            color = MaterialTheme.colorScheme.secondary
                                        )
                                        Spacer(modifier = Modifier.height(6.dp))
                                        Text(
                                            text = b.significance,
                                            style = MaterialTheme.typography.bodySmall,
                                            color = MaterialTheme.colorScheme.onSurfaceVariant
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
                3 -> {
                    // Official Syllabus Breakdown
                    LazyColumn(
                        modifier = Modifier.fillMaxSize(),
                        contentPadding = PaddingValues(16.dp),
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        item {
                            Text(
                                text = "G.C.E. (O/L) Official Term Breakdown",
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.primary
                            )
                        }

                        item {
                            SyllabusTermCard(
                                title = "Grade 10 • Term 1",
                                poetry = listOf("The Eagle (Tennyson)", "To the Evening Star (Blake)", "Farewell to Barn and Stack and Tree (Housman)"),
                                prose = listOf("The Lumber Room (Saki)", "The Lahore Attack (Sangakkara)"),
                                dramaOrNovel = "Introduction to selected drama & novel"
                            )
                        }

                        item {
                            SyllabusTermCard(
                                title = "Grade 10 • Term 2",
                                poetry = listOf("Big Match, 1983 (Gooneratne)", "The Terrorist, He's Watching (Szymborska)", "The Clown's Wife (Agard)", "The Huntsman (Lowbury)"),
                                prose = listOf("The Nightingale and the Rose (Wilde)"),
                                dramaOrNovel = "Novel selection (Twain / Abeysekara / Narayan)"
                            )
                        }

                        item {
                            SyllabusTermCard(
                                title = "Grade 10 • Term 3",
                                poetry = listOf("To the Nile (Keats)", "A Bird Came Down the Walk (Dickinson)", "Breakfast (Prevert)", "Once Upon a Time (Okara)"),
                                prose = listOf("An extract from 'Wave' (Deraniyagala)"),
                                dramaOrNovel = "Drama: The Bear (Chekhov)"
                            )
                        }

                        item {
                            SyllabusTermCard(
                                title = "Grade 11 • Term 1",
                                poetry = listOf("I Know Why the Caged Bird Sings (Angelou)", "War is Kind (Crane)", "Richard Cory (Robinson)", "The Camel's Hump (Kipling)"),
                                prose = listOf("Prose review"),
                                dramaOrNovel = "Drama: Twilight of a Crane (Kinoshita)"
                            )
                        }

                        item {
                            SyllabusTermCard(
                                title = "Grade 11 • Term 2 & 3",
                                poetry = listOf("The Earthen Goblet (Chattopadhyaya)", "Father and Son (Stevens)", "Upside-Down (Kushner)", "Fear (Mistral)", "Two's Company (Wilson)"),
                                prose = listOf("Comparative Prose & Critical Analysis"),
                                dramaOrNovel = "Novel study continuation & Mock Examinations"
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun SyllabusTermCard(
    title: String,
    poetry: List<String>,
    prose: List<String>,
    dramaOrNovel: String
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Column(modifier = Modifier.padding(14.dp)) {
            Text(text = title, style = MaterialTheme.typography.titleSmall, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = "Poetry: ${poetry.joinToString(", ")}", style = MaterialTheme.typography.bodySmall)
            Spacer(modifier = Modifier.height(2.dp))
            Text(text = "Prose: ${prose.joinToString(", ")}", style = MaterialTheme.typography.bodySmall)
            Spacer(modifier = Modifier.height(2.dp))
            Text(text = "Drama/Novel: $dramaOrNovel", style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.secondary)
        }
    }
}

@Composable
fun EmptyStateView(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    title: String,
    subtitle: String
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(
                icon,
                contentDescription = null,
                modifier = Modifier.size(56.dp),
                tint = MaterialTheme.colorScheme.outline
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = title, style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = subtitle,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                textAlign = androidx.compose.ui.text.style.TextAlign.Center
            )
        }
    }
}
