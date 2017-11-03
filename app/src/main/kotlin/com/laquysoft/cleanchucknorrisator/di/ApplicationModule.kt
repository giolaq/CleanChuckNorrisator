package com.laquysoft.cleanchucknorrisator.di

import android.content.Context
import com.laquysoft.cleanchucknorrisator.AndroidApplication
import com.laquysoft.cleanchucknorrisator.BuildConfig
import com.laquysoft.cleanchucknorrisator.framework.executor.ExecutionScheduler
import com.laquysoft.cleanchucknorrisator.framework.executor.ThreadScheduler
import com.laquysoft.cleanchucknorrisator.framework.network.Endpoints
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class ApplicationModule(private val application: AndroidApplication) {

    @Provides @Singleton fun provideApplicationContext(): Context = application

    @Provides @Singleton fun provideExecutionScheduler(threadScheduler: ThreadScheduler): ExecutionScheduler = threadScheduler

    @Provides @Singleton fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
                .baseUrl(Endpoints.ICNDB_BASE)
                .client(createClient())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
    }

    private fun createClient(): OkHttpClient {
        val okHttpClientBuilder: OkHttpClient.Builder = OkHttpClient.Builder()
        if (BuildConfig.DEBUG) {
            val loggingInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BASIC)
            okHttpClientBuilder.addInterceptor(loggingInterceptor)
        }
        return okHttpClientBuilder.build()
    }
}
