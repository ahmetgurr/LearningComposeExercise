package com.example.countermvvm

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class CounterViewModel() : ViewModel() {
    //private val repository: CounterRepository
    private val _repository: CounterRepository = CounterRepository()
    private val _count = mutableStateOf(_repository.getCount().count)

    // Expose an immutable state to the UI // türkçe: UI'ye değişmez bir durum sunma
    val count : MutableState<Int> = _count

    fun increment(){
        _repository.incrementCounter()
        _count.value = _repository.getCount().count
    }

    fun decrement(){
        _repository.decrementCounter()
        _count.value = _repository.getCount().count
    }
}