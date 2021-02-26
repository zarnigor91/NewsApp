package com.example.newtest.data.repository

import com.example.newtest.data.datasourse.database.NewsDao
import com.example.newtest.data.datasourse.rest.INetService
import com.example.newtest.data.model.NewsEntity
import com.example.newtest.data.model.NewsItem
import com.example.newtest.data.model.toEntity
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class NewsRepositoryImpl(
    private val netService: INetService,
    private val newsDao: NewsDao
) : NewsRepository {
    override fun getNews(): Single<List<NewsEntity>> {
        return netService.fetchNews()
            .map {
                it.results.map { it.toEntity() }
            }.doOnSuccess {
                newsDao.insertNews(it)
            }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
    }
}