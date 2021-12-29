package com.example.lab6danilov.dialogFragments

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

class AddNodeFragment(private var viewModel: NodeViewModel):DialogFragment() {

    //Layout init
    private lateinit var cancelButton: Button
    private lateinit var addNodeButton: Button
    private lateinit var nodeValueField: EditText
    private var nodeValueToAdd: Int? = null


    private fun insertNodeInDB(viewModel: NodeViewModel, value:Int, nodesList:MutableList<Node>){
        val nodeToInsert = Node(value, nodesList)
        viewModel.insertNode(nodeToInsert)
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val rootView: View = inflater.inflate(R.layout.dialog_add_node, container, false)

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