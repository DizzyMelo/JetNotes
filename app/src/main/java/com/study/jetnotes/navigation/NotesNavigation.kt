package com.study.jetnotes.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

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