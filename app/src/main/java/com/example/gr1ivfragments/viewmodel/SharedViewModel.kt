package com.example.gr1ivfragments.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel(){
    private val _msg = MutableLiveData<String>()
    val message: LiveData<String> = _msg

    fun setMessage(msg: String){
        _msg.value = msg
    }

}