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

    override fun passDataToA(nullString: String) {
        val bundle = Bundle()

        val transaction = this.supportFragmentManager.beginTransaction()
        val fragmentA = FragmentA()
        fragmentA.arguments = bundle

        transaction.replace(R.id.fragmentContainer, fragmentA)
        transaction.commit()
    }

    override fun passDataToB(textInputA: String) {
        val bundle = Bundle()
        bundle.putString("messageA", textInputA)

        val transaction = this.supportFragmentManager.beginTransaction()
        val fragmentB = FragmentB()
        fragmentB.arguments = bundle

        transaction.replace(R.id.fragmentContainer, fragmentB)
        transaction.commit()
    }

    override fun passDataToC(textInputA: String, textInputB: String) {
        val bundle = Bundle()
        bundle.putString("messageA", textInputA)
        bundle.putString("messageB", textInputB)


        val transaction = this.supportFragmentManager.beginTransaction()
        val fragmentC = FragmentС()
        fragmentC.arguments = bundle

        transaction.replace(R.id.fragmentContainer, fragmentC)
        transaction.commit()
    }

    override fun passDataToD(textInputA: String, textInputB: String, action: String) {
        val bundle = Bundle()
        bundle.putString("messageA", textInputA)
        bundle.putString("messageB", textInputB)
        bundle.putString("action", action)


        val transaction = this.supportFragmentManager.beginTransaction()
        val fragmentD = FragmentD()
        fragmentD.arguments = bundle

        transaction.replace(R.id.fragmentContainer, fragmentD)
        transaction.commit()
    }
}