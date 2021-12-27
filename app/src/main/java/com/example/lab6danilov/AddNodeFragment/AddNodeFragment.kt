package com.example.lab6danilov.AddNodeFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.DialogFragment
import com.example.lab6danilov.R
import com.example.lab6danilov.entities.Node
import com.example.lab6danilov.entities.NodeViewModel

class AddNodeFragment(viewModel: NodeViewModel):DialogFragment() {

    //Layout init
    lateinit var cancelButton: Button
    lateinit var addNodeButton: Button
    lateinit var nodeValueField: EditText
    var nodeValueToAdd: Int? = null
    var viewModel = viewModel


    private fun insertNodeInDB(viewModel: NodeViewModel, value:Int, nodesList:MutableList<Node>){
        val nodeToInsert = Node(value, nodesList)
        viewModel.insertNode(nodeToInsert)
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var rootView: View = inflater.inflate(R.layout.add_node_fragment, container, false)

        //Layout init
        cancelButton = rootView.findViewById(R.id.addNodeCancelButton)
        addNodeButton = rootView.findViewById(R.id.addNodeApproveButton)
        nodeValueField = rootView.findViewById(R.id.addNodeInput)


        //Button listeners
        cancelButton.setOnClickListener{
            dismiss()
        }
        addNodeButton.setOnClickListener{
            nodeValueToAdd = nodeValueField.text.toString().toInt()
            insertNodeInDB(viewModel, nodeValueToAdd!!, mutableListOf())

            dismiss()
        }

        return rootView
    }
}