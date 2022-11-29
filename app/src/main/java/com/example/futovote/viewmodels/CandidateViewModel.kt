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

    private val _candidates = MutableLiveData<List<Candidate>>()

    val candidates : LiveData<List<Candidate>> get()  = _candidates


    fun getCandidates() {

        viewModelScope.launch {
            try {
                _candidates.value = CandidateApi.retrofitService.getCandidates()
            } catch (e: Exception) {
                _candidates.value = listOf()
                e.message
            }
        }
    }
}