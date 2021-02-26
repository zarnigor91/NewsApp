package com.example.newtest.data.datasourse.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.newtest.data.model.MitableListConverters
import com.example.newtest.data.model.NewsEntity
import com.example.newtest.data.model.StringListConverters

@Database(entities = [NewsEntity::class], version = 1, exportSchema = false)
@TypeConverters(StringListConverters::class, MitableListConverters::class)
abstract class NewsDb : RoomDatabase() {

    abstract fun getNewsDao(): NewsDao

    companion object {
        private const val DB_NAME = "NewsDatabase"
        private var resultDataBase: NewsDb? = null


        fun getAppDatabase(context: Context): NewsDb {
            return Room.databaseBuilder(context.applicationContext, NewsDb::class.java, DB_NAME)
                .allowMainThreadQueries()
                .build()
        }
    }
}