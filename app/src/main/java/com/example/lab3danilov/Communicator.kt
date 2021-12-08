package com.example.lab3danilov

interface Communicator {
    fun passDataToA(nullString: String)
    fun passDataToB(textInputA: String)
    fun passDataToC(textInputA: String, textInputB: String)

    fun passDataToD(textInputA: String, textInputB: String, action: String)

}