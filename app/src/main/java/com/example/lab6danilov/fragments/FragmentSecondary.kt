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
import com.example.lab6danilov.dialogFragments.AddRelationFragment
import com.example.lab6danilov.R
import com.example.lab6danilov.entities.Node
import com.example.lab6danilov.entities.NodeViewModel

class FragmentSecondary(private var viewModel: NodeViewModel, private var nodeFirst: Node,
    private var isParentSelected: Boolean): Fragment() {

    private lateinit var communicator: Communicator

    //Layout init
    private var linearLayout: LinearLayout? = null
    private lateinit var parentButton: Button
    private lateinit var childButton: Button

    //Display nodes on screen
    private fun drawNodes(nodesList:MutableList<Node>, linearLayout: LinearLayout?){

        fun valueOfNodeContainsInNodesOf(nodeValue: Node, nodeNodes: Node, isContaining:Boolean): Boolean {
            return if (isContaining)
                nodeValue.value in nodeNodes.nodes.map { it.value }
            else
                nodeValue.value !in nodeNodes.nodes.map { it.value }
        }

        //Clear layout from previous results
        linearLayout?.removeAllViews()
        val fragmentManager = (activity as FragmentActivity).supportFragmentManager

        //Draw every node
        for (nodeSecond in nodesList){
            val nodeSecondValue = nodeSecond.value.toString()
            val nodeFirstValue = nodeFirst.value.toString()

            //Check if nodes are the same(2 - 2 must not be shown)
            if (nodeSecondValue!=nodeFirst.value.toString()){

                //Filter if connections are impossible
                if ((valueOfNodeContainsInNodesOf(nodeFirst, nodeSecond, false) && isParentSelected) ||
                    (valueOfNodeContainsInNodesOf(nodeSecond, nodeFirst, false) && !isParentSelected)){

                    val textView = TextView(context)

                    //If connection exists make it green
                    if ((valueOfNodeContainsInNodesOf(nodeSecond, nodeFirst, true) && isParentSelected) ||
                        (valueOfNodeContainsInNodesOf(nodeFirst, nodeSecond, true) && !isParentSelected)){
                        textView.setBackgroundColor(0xFF0FFF0F.toInt())
                    } else
                        textView.setBackgroundColor(0xFFFFFFFF.toInt())



                    "id: $nodeFirstValue | value = $nodeFirstValue − id: $nodeSecondValue | value = $nodeSecondValue".also { textView.text = it }
                    textView.setOnClickListener{
                        val addRelationFrag = AddRelationFragment(viewModel, nodeFirst, nodeSecond, isParentSelected)
                        addRelationFrag.show(fragmentManager, "NoteFragment")
                    }

                    linearLayout?.addView(textView)
                }
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


        //When List will change, nodes should be redrawn on screen
        viewModel.getAllNodes.observe(this) { nodes ->
            drawNodes(nodes, linearLayout)
        }

        //Back Button return to 1st Fragment
        requireActivity().onBackPressedDispatcher.addCallback(this) {
            communicator.drawFragment(FragmentMain(viewModel))
        }


        parentButton = view.findViewById(R.id.parentButton)
        parentButton.setOnClickListener{
            communicator.drawFragment(FragmentSecondary(viewModel, nodeFirst, true))
        }

        childButton = view.findViewById(R.id.childButton)
        childButton.setOnClickListener{
            communicator.drawFragment(FragmentSecondary(viewModel, nodeFirst, false))
        }


        return view
    }
}