package com.example.lab6danilov.fragments.dialogFragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.DialogFragment
import com.example.lab6danilov.R
import com.example.lab6danilov.database.entities.Node
import com.example.lab6danilov.database.viewmodels.NodeViewModel

class DeleteRelationFragment(
    private var viewModel: NodeViewModel, private var nodeFirst: Node,
    private var nodeSecond: Node, private var isParent: Boolean):DialogFragment() {

    //Layout init
    private lateinit var cancelButton: Button
    private lateinit var deleteRelationButton: Button

    private fun deleteRelation(isParent: Boolean){
        when(isParent) {
            true -> viewModel.updateNode(
                nodeFirst.value,
                nodeFirst.nodes.filter { it.value!=nodeSecond.value } as MutableList<Node>
            )
            false -> viewModel.updateNode(
                nodeSecond.value,
                nodeSecond.nodes.filter { it.value!=nodeFirst.value } as MutableList<Node>
            )
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val rootView: View = inflater.inflate(R.layout.dialog_delete_relation, container, false)

        //Layout init
        cancelButton = rootView.findViewById(R.id.deleteRelationCancelButton)
        deleteRelationButton = rootView.findViewById(R.id.deleteRelationApproveButton)

        //Button listeners
        cancelButton.setOnClickListener{
            dismiss()
        }
        deleteRelationButton.setOnClickListener{
            deleteRelation(isParent)
            dismiss()
        }

        return rootView
    }
}