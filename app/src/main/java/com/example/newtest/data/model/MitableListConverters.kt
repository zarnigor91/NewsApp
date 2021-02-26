package com.example.newtest.data.model

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MitableListConverters {
    @TypeConverter
    fun fromMultimediaStringToString(value: List<Multimedia>?): String? {
        return Gson().toJson(value)
    }

    @TypeConverter
    fun fromStringToListMultimedia(value: String?): List<Multimedia>? {
        return Gson().fromJson(
            value,
            object : TypeToken<List<Multimedia?>?>() {}.type
        )
    }

    }


