package com.example.mymemo.feature_note.presentation.notes

import com.example.mymemo.feature_note.domain.model.Note
import com.example.mymemo.feature_note.presentation.util.NoteOrder
import com.example.mymemo.feature_note.presentation.util.OrderType

data class NotesState(
    val notes: List<Note> = emptyList(),
    val noteOrder: NoteOrder = NoteOrder.Date(OrderType.Ascending),
    val isOrderSectionVisible: Boolean = false
)
