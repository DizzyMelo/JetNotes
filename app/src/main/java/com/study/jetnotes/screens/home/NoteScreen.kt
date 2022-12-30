package com.study.jetnotes.screens.home

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.study.jetnotes.R
import com.study.jetnotes.components.NoteButton
import com.study.jetnotes.components.NoteInputText
import com.study.jetnotes.components.NoteRow
import com.study.jetnotes.data.NotesDateSource
import com.study.jetnotes.model.Note
import java.time.format.DateTimeFormatter

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun NoteScreen(
    notes: List<Note>,
    onAddNote: (Note) -> Unit,
    onRemoveNote: (Note) -> Unit
) {
    var title by remember {
        mutableStateOf("")
    }

    var description by remember {
        mutableStateOf("")
    }

    val context = LocalContext.current

    Scaffold(
        topBar = { TopAppBar(
            title = { Text(text = stringResource(id = R.string.app_name)) },
            actions = {
                Icon(imageVector = Icons.Rounded.Notifications, contentDescription = "Top Bar icon")
            },
            backgroundColor = Color(0xFFDADFE3)
        )}
    ) {
        Column(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            NoteInputText(
                modifier = Modifier.padding(top = 10.dp, bottom = 10.dp),
                text = title,
                label = "Title",
                onTextChange = {
                    if (it.all { char -> char.isLetter() || char.isWhitespace() }) {
                        title = it
                    }
                }
            )
            NoteInputText(
                modifier = Modifier.padding(top = 10.dp, bottom = 20.dp),
                text = description,
                label = "Add Note",
                onTextChange = {
                    if (it.all { char -> char.isLetter() || char.isWhitespace() }) {
                        description = it
                    }
                },
                maxLines = 3
            )
            NoteButton(text = "Save", onClick = {
                if (title.isNotEmpty() && description.isNotEmpty()) {
                    // TODO: Save note to list, then clear inputs
                    onAddNote(Note(title = title, description = description))
                    title = ""
                    description = ""
                    Toast.makeText(context, "Note added", Toast.LENGTH_SHORT).show()
                }
            })
            Divider(modifier = Modifier.padding(10.dp))
            LazyColumn(content = {
                items(items = notes) { note ->
                    NoteRow(note = note, onNoteClicked = {
                        onRemoveNote(note)
                    })
                }
            })
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NotesScreenPreview() {
    NoteScreen(notes = NotesDateSource().loadNotes(), onAddNote = {}, onRemoveNote = {})
}