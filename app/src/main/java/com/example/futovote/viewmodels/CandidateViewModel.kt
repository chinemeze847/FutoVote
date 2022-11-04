package com.example.futovote.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.futovote.api.CandidateApi
import com.example.futovote.model.Candidate
import kotlinx.coroutines.launch


class CandidateViewModel : ViewModel() {

    private val _students = MutableLiveData<List<Candidate>>()

    val students : LiveData<List<Candidate>> get()  = _students

    /**
     * Call getStudents() on init so we can display status immediately.
     */
    init {
        Log.d("Candidate", "CandidateViewModel created!")
        getStudents()
    }

    /**
     * Gets Mars photos information from the Mars API Retrofit service and updates the
     * [Students] [List] [LiveData].
     */
    private fun getStudents() {

        viewModelScope.launch {
            try {
                _students.value = CandidateApi.retrofitService.getStudents()
            } catch (e: Exception) {
                _students.value = listOf()
                e.message
            }
        }
    }
}