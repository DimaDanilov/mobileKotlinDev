package com.example.lab6danilov

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import com.example.lab6danilov.AddNodeFragment.AddNoteFragment
import com.example.lab6danilov.entities.Node
import com.example.lab6danilov.entities.NodeViewModel
import com.example.lab6danilov.entities.NodeViewModelFactory

class MainActivity : AppCompatActivity() {

    //Layout init
    lateinit var context: Context
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

            linearLayout?.addView(textView)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Layout init
        linearLayout = findViewById(R.id.nodesContainer)
        context = this
        addButton = findViewById(R.id.addButton)

        //viewModel init
        val viewModelFactory = NodeViewModelFactory(application)
        val viewModel = ViewModelProvider(this, viewModelFactory).get(NodeViewModel::class.java)

        //When List will change, nodes should be redrawed on screen
        viewModel.getAllNodes.observe(this) { nodes ->
            drawNodes(nodes, linearLayout)
        }

        //Button Listener to add new nodes
        addButton.setOnClickListener{
            var addNodeFrag = AddNoteFragment(viewModel)
            addNodeFrag.show(supportFragmentManager, "NoteFragment")
        }

    }
}