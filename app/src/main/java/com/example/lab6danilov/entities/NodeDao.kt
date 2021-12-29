package com.example.lab6danilov.entities

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface NodeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNode(node: Node)

    @Query("UPDATE Node SET nodes=:nodes WHERE value=:value")
    suspend fun updateNode(value: Int, nodes: MutableList<Node>)

    @Query("SELECT * FROM Node")
    fun getAllNodes(): Flow<MutableList<Node>>
}