package com.example.android14starting

fun main() {


    print("Enter your age as a whole number: ")
    val enterTheAge = readLine()
    var myAge = enterTheAge?.toInt()

    if(myAge != null){
        if (myAge <18){
            println("You are not allowed to enter this area")
        }
        else if (myAge in 18..20){
            println("You can enter but you can not drink alcohol")
        }
        else if (myAge >40){
            println("You are too old to be here")
        }
        else{
            println("You can enter and drink alcohol")
        }

    }

}