package com.example.lab3danilov.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lab3danilov.Communicator
import com.example.lab3danilov.R
import kotlinx.android.synthetic.main.fragment_c.view.*
import kotlinx.android.synthetic.main.fragment_d.view.*

class FragmentD : Fragment() {
    private lateinit var communicator: Communicator

    var displayMessageA: String? = ""
    var displayMessageB: String? = ""
    var displayMessageAction: String? = ""
    var resultToPrint: Int? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_d, container, false)

        displayMessageA = arguments?.getString("messageA")
        displayMessageB = arguments?.getString("messageB")
        displayMessageAction = arguments?.getString("action")

        if (displayMessageAction=="+")
            resultToPrint = displayMessageB?.toInt()?.let { displayMessageA?.toInt()?.plus(it) }
        if (displayMessageAction=="-")
            resultToPrint = displayMessageB?.toInt()?.let { displayMessageA?.toInt()?.minus(it) }
        if (displayMessageAction=="*")
            resultToPrint = displayMessageB?.toInt()?.let { displayMessageA?.toInt()?.times(it) }
        if (displayMessageAction=="/")
            resultToPrint = displayMessageB?.toInt()?.let { displayMessageA?.toInt()?.div(it) }

        communicator = activity as Communicator

        //Кнопки в верхнем меню
        view.BtnToFragmentA4.setOnClickListener {
            communicator.passDataToA("")
        }
        view.BtnToFragmentB3.setOnClickListener {
            displayMessageA?.let { it1 -> communicator.passDataToB(it1) }
        }
        view.BtnToFragmentC2.setOnClickListener {
            displayMessageA?.let { it1 -> displayMessageB?.let { it2 ->
                communicator.passDataToC(it1,
                    it2
                )
            } }
        }
        view.DisButton4.isEnabled = false
        view.DisButton4.isClickable = false

        //Кнопка влево
        view.BtnToFragmentC.setOnClickListener {
            displayMessageA?.let { it1 -> displayMessageB?.let { it2 ->
                communicator.passDataToC(it1,
                    it2
                )
            } }
        }

        view.displayMessage.text = resultToPrint.toString()

        return view
    }
}