package com.example.lab6danilov.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Node(
    @PrimaryKey
    val value: Int,
    val nodes: MutableList<Node>
)