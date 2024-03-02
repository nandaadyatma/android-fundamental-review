package com.example.mymemo.feature_note.presentation.util

sealed class Screen(val route: String) {
    object NoteScreen: Screen("notes_screen")
    object AddEditScreen: Screen("add_edit_note_screen")
}