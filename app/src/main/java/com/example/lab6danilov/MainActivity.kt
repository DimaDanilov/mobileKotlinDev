package com.example.lab6danilov

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.lab6danilov.entities.NodeViewModel
import com.example.lab6danilov.entities.NodeViewModelFactory
import com.example.lab6danilov.fragments.*

class MainActivity : AppCompatActivity(), Communicator {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //viewModel init
        val viewModelFactory = NodeViewModelFactory(application)
        var viewModel = ViewModelProvider(this, viewModelFactory).get(NodeViewModel::class.java)

        val fragmentMain = FragmentMain(viewModel)
        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, fragmentMain).commit()
    }

    override fun DrawFragment(fragmentToDraw: Fragment) {
        val bundle = Bundle()

        val transaction = this.supportFragmentManager.beginTransaction()
        fragmentToDraw.arguments = bundle

        transaction.replace(R.id.fragmentContainer, fragmentToDraw)
        transaction.commit()
    }
}