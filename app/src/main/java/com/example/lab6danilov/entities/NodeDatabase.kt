package com.example.lab6danilov.entities

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [Node::class], version = 1)
@TypeConverters(Converters::class)
abstract class NodeDatabase: RoomDatabase() {

    abstract fun NodeDao(): NodeDao

    companion object {
        @Volatile
        private var INSTANCE: NodeDatabase? = null

        fun getDatabase(context: Context): NodeDatabase{
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    NodeDatabase::class.java,
                    "node_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}