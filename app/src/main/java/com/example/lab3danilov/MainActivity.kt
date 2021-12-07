package com.example.lab3danilov

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lab3danilov.fragments.*


class MainActivity : AppCompatActivity(), Communicator {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentA = FragmentA()
        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, fragmentA).commit()
    }

    override fun passDataAToB(editTextInput: String) {
        val bundle = Bundle()
        bundle.putString("messageA", editTextInput)

        val transaction = this.supportFragmentManager.beginTransaction()
        val fragmentB = FragmentB()
        fragmentB.arguments = bundle

        transaction.replace(R.id.fragmentContainer, fragmentB)
        transaction.commit()
    }

    override fun passDataBToC(editTextInputA: String, editTextInputB: String) {
        val bundle = Bundle()
        bundle.putString("messageA", editTextInputA)
        bundle.putString("messageB", editTextInputB)


        val transaction = this.supportFragmentManager.beginTransaction()
        val fragmentC = FragmentС()
        fragmentC.arguments = bundle

        transaction.replace(R.id.fragmentContainer, fragmentC)
        transaction.commit()
    }

    override fun passDataCToD(editTextInputA: String, editTextInputB: String, action: String) {
        val bundle = Bundle()
        bundle.putString("messageA", editTextInputA)
        bundle.putString("messageB", editTextInputB)
        bundle.putString("action", action)


        val transaction = this.supportFragmentManager.beginTransaction()
        val fragmentD = FragmentD()
        fragmentD.arguments = bundle

        transaction.replace(R.id.fragmentContainer, fragmentD)
        transaction.commit()
    }
}