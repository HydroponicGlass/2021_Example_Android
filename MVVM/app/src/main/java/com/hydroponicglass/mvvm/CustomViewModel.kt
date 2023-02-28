package com.hydroponicglass.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CustomViewModel(): ViewModel() {
    private val customRepository = CustomRepository()

    private val _data = MutableLiveData<CustomDataClass>()
    val data: LiveData<CustomDataClass> = _data

    fun getData(){
        _data.value = customRepository.getData()
    }
}