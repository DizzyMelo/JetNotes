package com.study.jetnotes.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.study.jetnotes.R

@Composable
fun NoteScreen(navController: NavController?) {
    var title by remember {
        mutableStateOf("")
    }

    var note by remember {
        mutableStateOf("")
    }

    

    Column(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TopAppBar(
            title = { Text(text = stringResource(id = R.string.app_name)) },
            actions = {}
        )
        TextField(
            value = title,
            onValueChange = {title = it},
            placeholder = { Text(text = "Title")},
            modifier = Modifier.background(
                Color.Transparent
            )
        )

        Spacer(modifier = Modifier.height(10.dp))
        TextField(
            value = note,
            onValueChange = {note = it},
            placeholder = { Text(text = "Add Note")}
        )
        Button(
            modifier = Modifier
                .clip(shape = CircleShape.copy(all = CornerSize(20.dp)))
                .padding(top = 10.dp),
            onClick = { /*TODO*/ }
        ) {
            Text(text = "Save")
        }
    }

}

@Preview(showBackground = true)
@Composable
fun NotesScreenPreview() {
    NoteScreen(null)
}