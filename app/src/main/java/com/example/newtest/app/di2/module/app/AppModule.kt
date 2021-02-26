package com.example.newtest.app.di2.module.app

import android.content.Context
import com.example.newtest.app.Application
import com.example.newtest.app.di2.scope.AppScope
import com.example.newtest.app.feature.news.news.RouterCOntroller
import com.example.newtest.data.datasourse.database.NewsDao
import com.example.newtest.data.datasourse.database.NewsDb
import dagger.Module
import dagger.Provides

@Module(
    includes = [
        ViewModelModule::class,
        RepoModule::class
    ]
)
class AppModule {
    @AppScope
    @Provides
    fun provideContext(application: Application): Context {
        return application.applicationContext
    }

    @AppScope
    @Provides
    fun appDb(application: Application): NewsDb {
        return NewsDb.getAppDatabase(application)
    }

    @AppScope
    @Provides
    fun newsDao(newsDb: NewsDb) : NewsDao {
        return newsDb.getNewsDao()
    }

    @AppScope
    @Provides
    fun router (): RouterCOntroller = RouterCOntroller()



}