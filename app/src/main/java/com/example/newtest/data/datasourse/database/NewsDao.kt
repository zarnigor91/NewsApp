package com.example.newtest.data.datasourse.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.newtest.data.model.NewsEntity
import com.example.newtest.data.model.NewsItem

@Dao
interface NewsDao {

//    @Query("SELECT * FROM news")
//    fun getAllNews(): List<NewsEntity>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNews(newsEntity: List<NewsEntity>)


}