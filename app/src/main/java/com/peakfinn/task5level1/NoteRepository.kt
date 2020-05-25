package com.peakfinn.task5level1

import android.content.Context
import androidx.lifecycle.LiveData

/**
 * Created by Finn Bon on 25/05/2020.
 */
class NoteRepository(context: Context) {

    private val noteDao: NoteDao

    init {
        val database = NotepadRoomDatabase.getDatabase(context)
        noteDao = database!!.noteDao()
    }

    fun getNotepad(): LiveData<Note?> {
        return noteDao.getNotepad()
    }

    suspend fun updateNotepad(note: Note) {
        noteDao.updateNote(note)
    }

}