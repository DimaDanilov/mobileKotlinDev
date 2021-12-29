package com.example.lab6danilov.database.repositories

import com.example.lab6danilov.database.entities.Node
import com.example.lab6danilov.database.entities.NodeDao

class NodeRepository(private val nodeDao: NodeDao) {

    val getAllNodes = nodeDao.getAllNodes()

    suspend fun insertNode(node: Node){
        nodeDao.insertNode(node)
    }

    suspend fun updateNode(value: Int, nodes: MutableList<Node>){
        nodeDao.updateNode(value, nodes)
    }

}