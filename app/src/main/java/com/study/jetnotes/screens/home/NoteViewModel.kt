package com.study.jetnotes.screens.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.study.jetnotes.model.Note
import com.study.jetnotes.repository.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(private val noteRepository: NoteRepository) : ViewModel() {
//    private var noteList = mutableStateListOf<Note>()
    private val _noteList = MutableStateFlow<List<Note>>(emptyList())
    private val noteList = _noteList.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            noteRepository.getAllNotes().distinctUntilChanged()
                .collect { listOfNotes ->
                    if (listOfNotes.isEmpty()) {
                        Log.d("NOTES", "List of notes: empty list")
                    } else {
                        _noteList.value = listOfNotes
                    }
                }
        }
    }

    suspend fun addNote(note: Note) = viewModelScope.launch { noteRepository.addNote(note) }

    suspend fun updateNote(note: Note) = viewModelScope.launch { noteRepository.updateNote(note) }

    suspend fun removeNote(note: Note)  = viewModelScope.launch { noteRepository.deleteNote(note) }

    fun getAllNotes(): StateFlow<List<Note>> = noteList

}