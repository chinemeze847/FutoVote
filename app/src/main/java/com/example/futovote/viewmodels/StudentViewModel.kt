package com.example.futovote.viewmodels


import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.futovote.api.StudentApi
import com.example.futovote.model.StudentRequestDto
import kotlinx.coroutines.launch

class StudentViewModel : ViewModel() {
    private val _isRegistered = MutableLiveData<String>()

    val registered : LiveData<String> get()  = _isRegistered

    fun loginStudent(request: StudentRequestDto){
        viewModelScope.launch {
            try {
                var statusStr = StudentApi.retrofitService.login(request)
                _isRegistered.value = statusStr;
                Log.i("MainActivity : ", statusStr)
            }catch (e: Exception)
            {
                e.message
            }
        }
    }
}