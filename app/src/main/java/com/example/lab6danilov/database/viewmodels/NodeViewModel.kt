package com.example.lab6danilov.database.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.lab6danilov.database.databases.NodeDatabase
import com.example.lab6danilov.database.entities.Node
import com.example.lab6danilov.database.repositories.NodeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NodeViewModel(application: Application): AndroidViewModel(application) {

    val getAllNodes: LiveData<MutableList<Node>>
    private val repository: NodeRepository

    init {
        val nodeDao = NodeDatabase.getDatabase(application).NodeDao()
        repository = NodeRepository(nodeDao)
        getAllNodes = repository.getAllNodes.asLiveData()
    }

    fun insertNode(node: Node){
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertNode(node)
        }
    }

    fun updateNode(value: Int, nodes: MutableList<Node>){
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateNode(value, nodes)
        }
    }

}