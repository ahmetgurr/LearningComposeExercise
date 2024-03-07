package com.example.inheritenceapp

class Offspring : Secondary(), Archer, Singer {

    override fun archery() {
        super.archery()
        println("Archery skill from sir Offspring")
    }

    override fun sing() {
        super.sing()
        println("Singing skill from sir Offspring")
    }
}