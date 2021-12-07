package com.example.lab3danilov.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lab3danilov.Communicator
import com.example.lab3danilov.R
import kotlinx.android.synthetic.main.fragment_a.view.*
import kotlinx.android.synthetic.main.fragment_b.view.*

class FragmentB : Fragment() {
    private lateinit var communicator: Communicator

    var displayMessageA: String? = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_b, container, false)


        communicator = activity as Communicator

        //Кнопка налево
        view.BtnToFragmentA.setOnClickListener {
            communicator.passDataToA("")
        }

        //Кнопка направо
        view.sendBtn2.setOnClickListener {
            displayMessageA = arguments?.getString("messageA")
            var displayMessageB = view.messageInput2.text.toString()
            displayMessageA?.let { it1 -> communicator.passDataToC(it1,displayMessageB) }
        }

        //Кнопка навигации наверху
        view.BtnToFragmentA2.setOnClickListener {
            communicator.passDataToA("")
        }
        view.DisButton2.isEnabled = false
        view.DisButton2.isClickable = false

        return view
    }
}