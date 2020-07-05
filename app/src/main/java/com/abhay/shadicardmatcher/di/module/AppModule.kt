package com.abhay.shadicardmatcher.di.module

import android.content.Context
import androidx.room.Room
import com.abhay.shadicardmatcher.data.ShadiCardMatcherRepository
import com.abhay.shadicardmatcher.data.api.ShadiCardMatcherApiService
import com.abhay.shadicardmatcher.data.api.ShadiCardMatcherRemoteDataSource
import com.abhay.shadicardmatcher.data.db.AppDatabase
import com.abhay.shadicardmatcher.data.db.ShadiCardMatcherLocalSource
import com.abhay.shadicardmatcher.utils.Constants
import com.abhay.shadicardmatcher.utils.Constants.Companion.DATABASE_NAME
import com.abhay.shadicardmatcher.utils.CoroutinesDispatcherProvider
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.Dispatchers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
object AppModule {

    @JvmStatic
    @Singleton
    @Provides
    fun provideShadiCardMatcherApiService(): ShadiCardMatcherApiService {
        val logger = HttpLoggingInterceptor()
        logger.level = HttpLoggingInterceptor.Level.BASIC

        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .client(OkHttpClient().newBuilder().addInterceptor(logger).build())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ShadiCardMatcherApiService::class.java)
    }

    @JvmStatic
    @Singleton
    @Provides
    fun provideRepository(
        localSource: ShadiCardMatcherLocalSource,
        remoteDataSource: ShadiCardMatcherRemoteDataSource,
        dispatcherProvider: CoroutinesDispatcherProvider
    ): ShadiCardMatcherRepository {
        return ShadiCardMatcherRepository(localSource, remoteDataSource, dispatcherProvider)
    }

    @JvmStatic
    @Singleton
    @Provides
    fun provideShadiCardMatcherLocalCache(
        database: AppDatabase,
        dispatcherProvider: CoroutinesDispatcherProvider
    ): ShadiCardMatcherLocalSource {
        return ShadiCardMatcherLocalSource(database.getShadiCardMatcherDao(), dispatcherProvider)
    }

    @JvmStatic
    @Singleton
    @Provides
    fun provideShadiMatcherRemoteDataSource(
        service: ShadiCardMatcherApiService
    ): ShadiCardMatcherRemoteDataSource {
        return ShadiCardMatcherRemoteDataSource(service)
    }

    @JvmStatic
    @Singleton
    @Provides
    fun provideCoroutinesDispatcherProvider(): CoroutinesDispatcherProvider {
        return CoroutinesDispatcherProvider(
            Dispatchers.Main,
            Dispatchers.IO,
            Dispatchers.Default
        )
    }

    @JvmStatic
    @Singleton
    @Provides
    fun provideDataBase(context: Context): AppDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            AppDatabase::class.java, DATABASE_NAME
        ).build()
    }

}


