package com.example.bukuinduk

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {
    private val _isPending = MutableLiveData<Boolean>()
    val isPending: LiveData<Boolean> get() = _isPending

    fun setPendingStatus(status: Boolean) {
        _isPending.value = status
    }
}
