package com.example.mymemo.feature_note.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.mymemo.ui.theme.LightBlue
import com.example.mymemo.ui.theme.LightMint
import com.example.mymemo.ui.theme.LightOrange
import com.example.mymemo.ui.theme.LightYellow
import com.example.mymemo.ui.theme.Pink

@Entity
data class Note(
    val title: String,
    val content: String,
    val timeStamp: Long,
    val color: Int,
    @PrimaryKey val id: Int? = null
) {
    companion object {
        val noteColors = listOf(
            LightBlue,
            LightMint,
            LightOrange,
            LightYellow,
            Pink
        )
    }
}

class InvalidNoteException(message: String): Exception(message)