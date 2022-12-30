package com.study.jetnotes.data

import com.study.jetnotes.model.Note

class NotesDateSource {
    fun loadNotes(): List<Note> {
        return listOf(
            Note(title = "Note title", description = "This is the content of the note with all the details I need"),
            Note(title = "Meeting notes", description = "Notes related to the meeting attended on this day with all the details I need"),
            Note(title = "Note title", description = "This is the content of the note with all the details I need"),
            Note(title = "Meeting notes", description = "Notes related to the meeting attended on this day with all the details I need"),
            Note(title = "Note title", description = "This is the content of the note with all the details I need"),
            Note(title = "Meeting notes", description = "Notes related to the meeting attended on this day with all the details I need"),
            Note(title = "Note title", description = "This is the content of the note with all the details I need"),
            Note(title = "Meeting notes", description = "Notes related to the meeting attended on this day with all the details I need"),
        )
    }
}