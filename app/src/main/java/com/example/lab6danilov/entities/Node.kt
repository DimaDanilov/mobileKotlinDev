package com.example.lab6danilov.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.coroutines.flow.Flow

@Entity
data class Node(
    @PrimaryKey
    val value: Int,
    val nodes: MutableList<Node>
)