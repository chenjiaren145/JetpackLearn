package com.example.jetpack.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class WatermelonViewModel : ViewModel() {


    private val _name = MutableLiveData("姓名")
    private val _age = MutableLiveData(0)

    val name: LiveData<String> = _name
    val age: LiveData<Int> = _age

    fun test() {

    }


}