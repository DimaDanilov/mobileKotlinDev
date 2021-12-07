package com.example.lab3danilov.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lab3danilov.Communicator
import com.example.lab3danilov.R
import kotlinx.android.synthetic.main.fragment_c.view.*

class FragmentС : Fragment() {
    private lateinit var communicator: Communicator

    var displayMessageA: String? = ""
    var displayMessageB: String? = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_c, container, false)

        communicator = activity as Communicator

        displayMessageA = arguments?.getString("messageA")
        displayMessageB = arguments?.getString("messageB")

        view.plusBtn.setOnClickListener {
            displayMessageA?.let { it1 -> displayMessageB?.let { it2 ->
                communicator.passDataCToD(it1,
                    it2, "+")
            } }
        }
        view.minusBtn.setOnClickListener {
            displayMessageA?.let { it1 -> displayMessageB?.let { it2 ->
                communicator.passDataCToD(it1,
                    it2, "-")
            } }
        }
        view.multiplyBtn.setOnClickListener {
            displayMessageA?.let { it1 -> displayMessageB?.let { it2 ->
                communicator.passDataCToD(it1,
                    it2, "*")
            } }
        }
        view.divideBtn.setOnClickListener {
            displayMessageA?.let { it1 -> displayMessageB?.let { it2 ->
                communicator.passDataCToD(it1,
                    it2, "/")
            } }
        }

        return view
    }
}