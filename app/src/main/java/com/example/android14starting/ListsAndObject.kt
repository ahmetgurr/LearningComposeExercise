package com.example.android14starting

fun main(){

    //immutable list / cannot be changed cannot add or remove items
    //val shoppingList = listOf("Lamborghini", "Penthouse", "Rolex")

    //mutable list / can be changed can add or remove items
    val shoppingList = mutableListOf("Lamborghini", "Penthouse", "Rolex")


    shoppingList.add("Hyundai") //add item to list
    shoppingList.remove("Rolex") //remove item from list
    shoppingList.removeAt(0) //remove item at index 0
    shoppingList[1] = "Tesla" //change item at index 1
    shoppingList.add(0, "Mitshubishi") //add item at index 0
    // shoppingList[3] ="Ferrari" //change item at index 3
    shoppingList.set(2, "Maserati") //change item at index 2

    if(shoppingList.contains("Tesla")){
        println("You have a Tesla")
    }
    else{
        println("You don't have a Tesla")
    }

    for (index in 0 until shoppingList.size){
        println("item ${shoppingList[index]} is at index $index")
    }

    println(shoppingList)
    println(shoppingList[0])
    println(shoppingList.indexOf("Tesla"))

}