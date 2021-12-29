package com.example.lab6danilov

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.lab6danilov.database.viewmodels.NodeViewModel
import com.example.lab6danilov.database.viewmodels.NodeViewModelFactory
import com.example.lab6danilov.fragments.*

class MainActivity : AppCompatActivity(), Communicator {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //viewModel init
        val viewModelFactory = NodeViewModelFactory(application)
        val viewModel = ViewModelProvider(this, viewModelFactory)[NodeViewModel::class.java]

        val fragmentMain = FragmentMain(viewModel)
        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, fragmentMain).commit()
    }

    override fun drawFragment(fragmentToDraw: Fragment) {
        val bundle = Bundle()

        val transaction = this.supportFragmentManager.beginTransaction()
        fragmentToDraw.arguments = bundle

        transaction.replace(R.id.fragmentContainer, fragmentToDraw)
        transaction.commit()
    }
}