package com.peakfinn.task5level1

import android.app.Application
import androidx.lifecycle.AndroidViewModel

/**
 * Created by Finn Bon on 25/05/2020.
 */
class MainActivityViewModel(application: Application) : AndroidViewModel(application) {
    private val noteRepository = NoteRepository(application.applicationContext)
    val note = noteRepository.getNotepad()
}