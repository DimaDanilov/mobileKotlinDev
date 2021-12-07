package com.example.lab3danilov

interface Communicator {
    fun passDataAToB(editTextInput: String)
    fun passDataBToC(editTextInputA: String, editTextInputB: String)
    fun passDataCToD(editTextInputA: String, editTextInputB: String, action: String)

}