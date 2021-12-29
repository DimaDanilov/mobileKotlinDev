package com.example.lab6danilov.database

import androidx.room.TypeConverter
import com.example.lab6danilov.database.entities.Node
import com.google.gson.Gson

class Converters {
    @TypeConverter
    fun listToJson(value: MutableList<Node>?): String = Gson().toJson(value)

    @TypeConverter
    fun jsonToList(value: String) = Gson().fromJson(value, Array<Node>::class.java).toMutableList()
}