package com.example.lab3danilov.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lab3danilov.Communicator
import com.example.lab3danilov.R
import kotlinx.android.synthetic.main.fragment_a.view.*

class FragmentA : Fragment() {
    private lateinit var communicator: Communicator

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_a, container, false)

        communicator = activity as Communicator

        //Кнопка навигации наверху
        view.DisButton1.isEnabled = false
        view.DisButton1.isClickable = false

        //Кнопка направо
        view.sendBtn.setOnClickListener {
            communicator.passDataToB(view.messageInput.text.toString())
        }
        return view
    }
}