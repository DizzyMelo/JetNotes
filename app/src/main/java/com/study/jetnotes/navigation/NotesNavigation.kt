package com.study.jetnotes.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.study.jetnotes.data.NotesDateSource
import com.study.jetnotes.model.Note
import com.study.jetnotes.screens.home.NoteScreen

@Composable
fun NotesNavigation() {

    val navController = rememberNavController()
    val notes = remember {
        mutableListOf<Note>()
    }

    NavHost(
        navController = navController,
        startDestination = NotesScreens.NoteScreen.name,
        builder = {
            composable(route = NotesScreens.NoteScreen.name) {
                NoteScreen(
                    notes = notes,
                    onAddNote = {
                        notes.add(it)
                    },
                    onRemoveNote = {
                        notes.remove(it)
                    })
            }
        }
    )
}