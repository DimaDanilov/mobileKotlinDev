package com.example.lab6danilov.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.example.lab6danilov.Communicator
import com.example.lab6danilov.DialogFragments.AddNodeFragment
import com.example.lab6danilov.DialogFragments.AddRelationFragment
import com.example.lab6danilov.R
import com.example.lab6danilov.entities.Node
import com.example.lab6danilov.entities.NodeViewModel

class FragmentSecondary(viewModel: NodeViewModel, nodeCheck: String): Fragment() {
    private lateinit var communicator: Communicator
    var viewModel = viewModel
    var nodeCheck = nodeCheck

    //Buttons
    var isParentSelected: Boolean = false
    lateinit var parentButton: Button
    lateinit var childButton: Button


    //Layout init
    var linearLayout: LinearLayout? = null

    //Display nodes on screen
    private fun drawNodes(nodesList:MutableList<Node>, linearLayout: LinearLayout?){
        //Clear layout from previous results
        linearLayout?.removeAllViews();
        var fragmentManager = (activity as FragmentActivity).supportFragmentManager

        //Draw every node
        for (node in nodesList){
            val nodeValue = node.value.toString()

            //Проверка на совпадение нодов(2 и 2 не должны показываться)
            if (nodeValue!=nodeCheck){
                val textView = TextView(context)

                textView.text = "id: $nodeCheck | value = $nodeCheck − id: $nodeValue | value = $nodeValue"
                textView.setOnClickListener{
                    var addRelationFrag = AddRelationFragment(viewModel, isParentSelected)
                    addRelationFrag.show(fragmentManager, "NoteFragment")
                }

                linearLayout?.addView(textView)
            }

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?{
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_secondary, container, false)
        communicator = activity as Communicator


        //Layout init
        linearLayout = view.findViewById(R.id.nodesContainer)


        //When List will change, nodes should be redrawed on screen
        viewModel.getAllNodes.observe(this) { nodes ->
            drawNodes(nodes, linearLayout)
        }

        //Back Button return to 1st Fragment
        requireActivity().onBackPressedDispatcher.addCallback(this) {
            communicator.DrawFragment(FragmentMain(viewModel))
        }


        parentButton = view.findViewById(R.id.parentButton)
        parentButton.setOnClickListener{
            isParentSelected = true
        }

        childButton = view.findViewById(R.id.childButton)
        childButton.setOnClickListener{
            isParentSelected = false
        }


        return view
    }
}