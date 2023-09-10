package com.redvelvet.imovie.di

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.gson.Gson
import com.redvelvet.remote.BuildConfig
import com.redvelvet.remote.service.MovieApiService
import com.redvelvet.remote.service.TriviaService
import com.redvelvet.remote.util.interceptor.AuthorizationInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    private const val TRIVIA_BASE_URL = "https://the-trivia-api.com/v2/"


    @Provides
    fun provideTriviaService(
        okHttpClient: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory
    ): TriviaService {
        return provideRetrofit(TRIVIA_BASE_URL, okHttpClient, gsonConverterFactory)
            .create(TriviaService::class.java)
    }

    @Singleton
    @Provides
    fun provideFirebaseFireStore(): FirebaseFirestore = Firebase.firestore


    @Singleton
    @Provides
    fun provideFirebaseAuth(): FirebaseAuth = Firebase.auth


    @Singleton
    @Provides
    fun provideMovieApiService(
        okHttpClient: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory
    ): MovieApiService {
        return provideRetrofit(BASE_URL,okHttpClient, gsonConverterFactory)
            .create(MovieApiService::class.java)
    }

    private const val BASE_URL = BuildConfig.BASE_URL

    @Singleton
    @Provides
    fun provideRetrofit(
        url: String,
        client: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(url)
            .client(client)
            .addConverterFactory(gsonConverterFactory)
            .build()
    }

    @Singleton
    @Provides
    fun provideGsonConverterFactory(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }

    @Singleton
    @Provides
    fun provideGson(): Gson {
        return Gson()
    }

    private const val TIMEOUT = 30L

    @Singleton
    @Provides
    fun provideOkHttpClient(
        loggingInterceptor: HttpLoggingInterceptor,
        authorizationInterceptor: AuthorizationInterceptor,
    ): OkHttpClient = OkHttpClient.Builder()
        .apply {
            addInterceptor(loggingInterceptor)
            addInterceptor(authorizationInterceptor)
        }
        .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
        .readTimeout(TIMEOUT, TimeUnit.SECONDS)
        .build()

    @Singleton
    @Provides
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    @Singleton
    @Provides
    fun provideAuthInterceptor() = AuthorizationInterceptor()


}