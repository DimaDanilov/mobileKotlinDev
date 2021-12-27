package com.example.lab6danilov.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.example.lab6danilov.AddNodeFragment.AddNodeFragment
import com.example.lab6danilov.Communicator
import com.example.lab6danilov.R
import com.example.lab6danilov.entities.Node
import com.example.lab6danilov.entities.NodeViewModel

class FragmentMain(viewModel: NodeViewModel): Fragment() {
    private lateinit var communicator: Communicator
    var viewModel = viewModel

    //Layout init
    var linearLayout: LinearLayout? = null
    lateinit var addButton: Button

    //Display nodes on screen
    private fun drawNodes(nodesList:MutableList<Node>, linearLayout: LinearLayout?){
        //Clear layout from previous results
        linearLayout?.removeAllViews();

        //Draw every node
        for (node in nodesList){
            val textView = TextView(context)

            val nodeValue = node.value.toString()
            textView.setText("id = " + nodeValue + " value = " + nodeValue)
            textView.setOnClickListener{
                communicator.DrawFragment(FragmentSecondary(viewModel))
            }

            linearLayout?.addView(textView)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?{
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_main, container, false)
        var fragmentManager = (activity as FragmentActivity).supportFragmentManager
        communicator = activity as Communicator

        //Layout init
        linearLayout = view.findViewById(R.id.nodesContainer)
        addButton = view.findViewById(R.id.addButton)


        //When List will change, nodes should be redrawed on screen
        viewModel.getAllNodes.observe(this) { nodes ->
            drawNodes(nodes, linearLayout)
        }

        //Button Listener to add new nodes
        addButton.setOnClickListener{
            var addNodeFrag = AddNodeFragment(viewModel)
            addNodeFrag.show(fragmentManager, "NoteFragment")
        }
        return view
    }
}