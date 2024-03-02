package com.example.mymemo.feature_note.presentation.util

import com.example.mymemo.feature_note.domain.use_case.AddNote
import com.example.mymemo.feature_note.domain.use_case.DeleteNote
import com.example.mymemo.feature_note.domain.use_case.GetNote
import com.example.mymemo.feature_note.domain.use_case.GetNotes

class NoteUseCases(
    val getNotes: GetNotes,
    val deleteNote: DeleteNote,
    val addNote: AddNote,
    val getNote: GetNote
) {
}