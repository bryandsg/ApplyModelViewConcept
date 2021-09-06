package com.hashiradev.viewmodellifecycle

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    var counter = MutableLiveData<String>().apply { value = counterValue.toString() }
    private var counterValue: Int = 0

    private fun setcounter() {
        counter.value = counterValue.toString()
    }

    //validateCounter turns the updatecounter because this new name make more sense
    private fun updateCounter() {
        if(counterValue > 5 ) {
            counterValue = 0
        }
        setcounter()
    }

    fun counter() {
        counterValue++
        updateCounter()
    }
}