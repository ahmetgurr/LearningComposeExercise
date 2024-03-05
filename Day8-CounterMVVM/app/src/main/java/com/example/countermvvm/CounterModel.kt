package com.example.countermvvm

data class CounterModel(var count: Int = 0)

class CounterRepository(){
    private var _counter = CounterModel(0)

    fun getCount() = _counter

    fun incrementCounter() {
        _counter.count++
    }

    fun decrementCounter() {
        _counter.count--
    }

}
