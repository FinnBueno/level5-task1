package com.peakfinn.task5level1

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * Created by Finn Bon on 25/05/2020.
 */
class EditViewModel(application: Application) : AndroidViewModel(application) {

    private val noteRepository = NoteRepository(application.applicationContext)
    private val mainScope = CoroutineScope(Dispatchers.Main)

    val note = MutableLiveData<Note?>()
    val error = MutableLiveData<String?>()
    val success = MutableLiveData<Boolean>()

    fun updateNote() {
        if (isNoteValid()) {
            mainScope.launch {
                withContext(Dispatchers.IO) {
                    noteRepository.updateNotepad(note.value!!)
                }
                success.value = true
            }
        }
    }

    private fun isNoteValid(): Boolean {
        return when {
            note.value == null -> {
                error.value = "Note must not be null"
                false
            }
            note.value!!.title.isBlank() -> {
                error.value = "Title must not be empty"
                false
            }
            else -> true
        }
    }

}
