package com.example.lab3danilov.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lab3danilov.R
import kotlinx.android.synthetic.main.fragment_d.view.*

class FragmentD : Fragment() {

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


        view.displayMessage.text = resultToPrint.toString()

        return view
    }
}