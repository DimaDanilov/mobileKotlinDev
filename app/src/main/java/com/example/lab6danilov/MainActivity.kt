package com.example.lab6danilov

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import com.example.lab6danilov.entities.Node
import com.example.lab6danilov.entities.NodeViewModel
import com.example.lab6danilov.entities.NodeViewModelFactory

class MainActivity : AppCompatActivity() {

    //Для вставки в экран
    lateinit var context: Context
    var linearLayout: LinearLayout? = null


    private fun insertNodeInDB(viewModel:NodeViewModel, value:Int, nodesList:MutableList<Node>){
        val nodeToInsert = Node(value, nodesList)
        viewModel.insertNode(nodeToInsert)
    }

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

        //viewModel init
        val viewModelFactory = NodeViewModelFactory(application)
        val viewModel = ViewModelProvider(this, viewModelFactory).get(NodeViewModel::class.java)

        insertNodeInDB(viewModel, 4, mutableListOf())

        viewModel.getAllNodes.observe(this) { nodes ->
            drawNodes(nodes, linearLayout)
        }


    }
}