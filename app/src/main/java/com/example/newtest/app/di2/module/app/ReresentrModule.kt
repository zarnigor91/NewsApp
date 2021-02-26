package com.example.newtest.app.di2.module.app

import com.example.newtest.app.di2.scope.AppScope
import com.example.newtest.data.datasourse.database.NewsDao
import com.example.newtest.data.datasourse.rest.INetService
import com.example.newtest.data.repository.NewsRepository
import com.example.newtest.data.repository.NewsRepositoryImpl
import dagger.Module
import dagger.Provides

@Module
class ReresentrModule {
    @Provides
    @AppScope
    fun provideNewsRepository(service: INetService, newsDao: NewsDao): NewsRepository {
        return NewsRepositoryImpl(service, newsDao)
    }

}