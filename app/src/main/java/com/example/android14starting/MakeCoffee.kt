package com.example.android14starting

fun main() {
    println("Who is this coffee for?")
    val name = readln()
    println("How many sugars do you want?")
    val sugarCount = readln()
    val sugarCountInt = sugarCount.toInt()

    makeCoffee(sugarCountInt, name)
}

fun makeCoffee(sugarCount: Int, name: String){
    if (sugarCount == 1){
        println("$name is drinking coffee with $sugarCount sugar")
    }
    else if (sugarCount == 2){
        println("$name is drinking coffee with $sugarCount sugar")
    }
    else if (sugarCount == 30){
        println("$name is drinking coffee with $sugarCount sugar")
    }
    else if (sugarCount == 0){
        println("$name is drinking coffee with $sugarCount sugar")
    }
    else{
        println("$name  is drinking coffee with $sugarCount sugar")
    }
}