package com.example.lab6danilov.dialogFragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.DialogFragment
import com.example.lab6danilov.R
import com.example.lab6danilov.entities.Node
import com.example.lab6danilov.entities.NodeViewModel

class AddRelationFragment(
    private var viewModel: NodeViewModel, private var nodeFirst:Node,
    private var nodeSecond:Node, private var isParent: Boolean):DialogFragment() {

    //Layout init
    private lateinit var cancelButton: Button
    private lateinit var addRelationButton: Button

    private fun makeRelation(isParent: Boolean){
        when(isParent) {
            true -> {
                viewModel.updateNode(
                    nodeSecond.value,
                    (nodeSecond.nodes + mutableListOf(Node(nodeFirst.value, nodeFirst.nodes))) as MutableList<Node>
                )
            }
            false -> {
                viewModel.updateNode(
                    nodeFirst.value,
                    (nodeFirst.nodes + mutableListOf(Node(nodeSecond.value, nodeSecond.nodes))) as MutableList<Node>
                )
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val rootView: View = inflater.inflate(R.layout.dialog_add_relation, container, false)

        //Layout init
        cancelButton = rootView.findViewById(R.id.addRelationCancelButton)
        addRelationButton = rootView.findViewById(R.id.addRelationApproveButton)

        //Button listeners
        cancelButton.setOnClickListener{
            dismiss()
        }
        addRelationButton.setOnClickListener{
            makeRelation(isParent)
            dismiss()
        }

        return rootView
    }
}