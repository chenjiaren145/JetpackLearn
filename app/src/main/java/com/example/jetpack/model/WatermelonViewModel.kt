package com.example.jetpack.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class WatermelonViewModel : ViewModel() {


    private val _name = MutableLiveData("姓名")
    private val _age = MutableLiveData(0)

    val name: LiveData<String> = _name
    val age: LiveData<Int> = _age

    fun test() {

    }


}