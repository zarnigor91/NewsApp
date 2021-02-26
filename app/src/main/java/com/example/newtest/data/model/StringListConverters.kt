package com.example.newtest.data.model

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class StringListConverters {
    @TypeConverter
    fun fromListStringToString(value: List<String>?): String? {
        return Gson().toJson(value)
    }

    @TypeConverter
    fun fromStringToListString(value: String?): List<String>? {
        return Gson().fromJson(
            value,
            object : TypeToken<List<String?>?>() {}.type
        )
    }

    }


