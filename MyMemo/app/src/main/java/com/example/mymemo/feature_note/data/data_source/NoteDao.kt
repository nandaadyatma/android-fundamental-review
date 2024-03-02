package com.example.mymemo.feature_note.data.data_source

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mymemo.feature_note.domain.model.Note
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {

    @Query("SELECT * FROM note")
    fun getNotes(): Flow<List<Note>> //karena ini pake flow jadi tidak pake suspend, flow karena list of note

    @Query("SELECT * FROM note WHERE id = :id")
    suspend fun getNoteById(id: Int): Note? //pake suspend

    @Insert(onConflict = OnConflictStrategy.REPLACE) //dengan id yang sama, maka akan direplace (INSERT/UPDATE)
    suspend fun insertNote(note: Note)

    @Delete
    suspend fun deleteNote(note: Note)
}