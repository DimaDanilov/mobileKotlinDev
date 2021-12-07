package com.example.lab3danilov

interface Communicator {
    fun passDataToA(nullString: String)
    fun passDataToB(textInputA: String)
    fun passDataToC(textInputA: String, textInputB: String)

    fun passDataCToD(editTextInputA: String, editTextInputB: String, action: String)

}