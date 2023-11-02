package com.gonzalez.blanchard.remotedatasource.di

import com.gonzalez.blanchard.interceptor.AccessTokenInterceptor
import com.gonzalez.blanchard.remotedatasource.api.SurveyApi
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RemoteDataSourceModule {

    @Provides
    @Singleton
    fun provideOkHttpClientBuilder(
        accessTokenInterceptor: AccessTokenInterceptor,
    ): OkHttpClient.Builder {
        val okHttpClientBuilder = OkHttpClient.Builder()
        okHttpClientBuilder.addInterceptor(accessTokenInterceptor)
        return okHttpClientBuilder
    }

    @Provides
    @Singleton
    fun provideMoshi(): Moshi =
        Moshi.Builder()
            .add(KotlinJsonAdapterFactory()).build()

    @Provides
    @Singleton
    fun provideCoreApi(
        okHttpClientBuilder: OkHttpClient.Builder,
        moshi: Moshi,
    ): SurveyApi {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://survey-api.nimblehq.co")
            .client(okHttpClientBuilder.build())
            .addConverterFactory(MoshiConverterFactory.create(moshi).asLenient())
            .build()

        return retrofit.create(SurveyApi::class.java)
    }
}
