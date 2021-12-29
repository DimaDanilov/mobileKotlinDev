package com.example.lab6danilov.fragments.colors

import com.example.lab6danilov.entities.Node

fun chooseColorForMain(node: Node, nodesList: MutableList<Node>): Int {
    fun hasChild(node: Node, nodesList: MutableList<Node>): Boolean {
        val allChildrenOfNodes = nodesList.map { it -> it.nodes.map { it.value } }
        val containingOfValueInNodes = allChildrenOfNodes.map { it.contains(node.value) }
        return true in containingOfValueInNodes
    }
    fun hasParent(node: Node): Boolean {
        return !node.nodes.isNullOrEmpty()
    }

    return if (hasParent(node)&&(hasChild(node, nodesList)))
        0xFFF00000.toInt()
    else if (hasParent(node))
        0xFFFFE53F.toInt()
    else if (hasChild(node, nodesList))
        0xFF4FC1FF.toInt()
    else
        0xFFFFFFFF.toInt()
}