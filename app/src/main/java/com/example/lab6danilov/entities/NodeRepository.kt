package com.example.lab6danilov.entities

class NodeRepository(private val nodeDao: NodeDao) {

    val getAllNodes = nodeDao.getAllNodes()

    suspend fun insertNode(node: Node){
        nodeDao.insertNode(node)
    }

    suspend fun updateNode(value: Int, nodes: MutableList<Node>){
        nodeDao.updateNode(value, nodes)
    }

}