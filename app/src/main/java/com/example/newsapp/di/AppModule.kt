package com.example.newsapp.di

import com.example.newsapp.BuildConfig
import com.example.newsapp.feature_news_page.data.network.NewsAPIService
import com.example.newsapp.feature_news_page.data.repository.NewsRepositoryImpl
import com.example.newsapp.feature_news_page.domain.repository.NewsRepository
import com.example.newsapp.feature_news_page.domain.use_case.GetNewsItems
import com.example.newsapp.feature_news_page.domain.use_case.NewsItemsUseCases
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    private val baseUrl = BuildConfig.NEWS_API_ENDPOINT

    @Provides
    @Singleton
    fun provideMoshi(): Moshi{
        return Moshi.Builder()
            .addLast(KotlinJsonAdapterFactory())
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(moshi: Moshi):Retrofit{
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    }

    @Provides
    @Singleton
    fun provideNewsService(retrofit: Retrofit): NewsAPIService{
        return retrofit.create(NewsAPIService::class.java)
    }

    @Provides
    @Singleton
    fun provideNewsRepository(service: NewsAPIService): NewsRepository {
        return NewsRepositoryImpl(service)
    }

    @Provides
    @Singleton
    fun provideNewsUseCase(repository: NewsRepository): NewsItemsUseCases{
        return NewsItemsUseCases(
            getNewsItems = GetNewsItems(repository)
        )
    }
}
