package com.study.jetnotes.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.study.jetnotes.screens.home.NoteScreen
import com.study.jetnotes.screens.home.NoteViewModel

@Composable
fun NotesNavigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = NotesScreens.NoteScreen.name,
        builder = {
            composable(route = NotesScreens.NoteScreen.name) {

            }
        }
    )
}