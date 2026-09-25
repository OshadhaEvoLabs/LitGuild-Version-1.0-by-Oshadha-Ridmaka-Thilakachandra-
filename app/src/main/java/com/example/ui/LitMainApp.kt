package com.example.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.LibraryBooks
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.ui.screens.*
import com.example.ui.viewmodel.LitViewModel

sealed class Screen(val route: String, val label: String, val icon: androidx.compose.ui.graphics.vector.ImageVector) {
    object Library : Screen("library", "Library", Icons.AutoMirrored.Filled.LibraryBooks)
    object ContextPractice : Screen("context_practice", "Context", Icons.Default.Psychology)
    object EssayGuild : Screen("essay_guild", "Essays", Icons.Default.BorderColor)
    object AiTutor : Screen("ai_tutor", "AI Tutor", Icons.Default.AutoAwesome)
    object RevisionHub : Screen("revision_hub", "Revision", Icons.Default.Bookmarks)
    object WorkDetail : Screen("work_detail", "Detail", Icons.Default.Book)
    object Auth : Screen("auth", "Sign In", Icons.Default.AccountCircle)
}

@Composable
fun LitMainApp(
    viewModel: LitViewModel = viewModel()
) {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val bottomNavItems = listOf(
        Screen.Library,
        Screen.ContextPractice,
        Screen.EssayGuild,
        Screen.AiTutor,
        Screen.RevisionHub
    )

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            NavigationBar(
                modifier = Modifier.testTag("main_bottom_nav"),
                containerColor = MaterialTheme.colorScheme.surface
            ) {
                bottomNavItems.forEach { screen ->
                    val isSelected = currentRoute == screen.route
                    NavigationBarItem(
                        selected = isSelected,
                        onClick = {
                            if (currentRoute != screen.route) {
                                navController.navigate(screen.route) {
                                    popUpTo(navController.graph.findStartDestination().id) {
                                        saveState = true
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            }
                        },
                        icon = { Icon(screen.icon, contentDescription = screen.label) },
                        label = { Text(screen.label) },
                        modifier = Modifier.testTag("nav_item_${screen.route}")
                    )
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Library.route,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            composable(Screen.Library.route) {
                LibraryScreen(
                    viewModel = viewModel,
                    onWorkSelected = { work ->
                        navController.navigate(Screen.WorkDetail.route)
                    },
                    onOpenAuth = {
                        navController.navigate(Screen.Auth.route)
                    }
                )
            }

            composable(Screen.WorkDetail.route) {
                val selectedWork by viewModel.selectedWork.collectAsState()
                WorkDetailScreen(
                    work = selectedWork,
                    viewModel = viewModel,
                    onBack = { navController.popBackStack() },
                    onNavigateToContextPractice = {
                        navController.navigate(Screen.ContextPractice.route)
                    },
                    onNavigateToEssayGuild = {
                        navController.navigate(Screen.EssayGuild.route)
                    }
                )
            }

            composable(Screen.ContextPractice.route) {
                ContextPracticeScreen(viewModel = viewModel)
            }

            composable(Screen.EssayGuild.route) {
                EssayGuildScreen(viewModel = viewModel)
            }

            composable(Screen.AiTutor.route) {
                AiTutorScreen(viewModel = viewModel)
            }

            composable(Screen.RevisionHub.route) {
                RevisionHubScreen(
                    viewModel = viewModel,
                    onOpenAuth = {
                        navController.navigate(Screen.Auth.route)
                    }
                )
            }

            composable(Screen.Auth.route) {
                AuthScreen(
                    viewModel = viewModel,
                    onAuthSuccess = {
                        navController.popBackStack()
                    }
                )
            }
        }
    }
}
