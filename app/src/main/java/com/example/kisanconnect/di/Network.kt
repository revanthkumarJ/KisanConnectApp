package com.example.kisanconnect.di


import com.example.kisanconnect.features.Screens.Home.data.remote.HomeApiService
import com.example.kisanconnect.features.Screens.Product.data.remote.ProductApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    // Provide Retrofit instance
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://192.168.43.186:3000/") // Replace with your actual API base URL
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    // Provide ApiService instance for home
    @Provides
    fun provideHomeApiService(retrofit: Retrofit): HomeApiService {
        return retrofit.create(HomeApiService::class.java)
    }

    // Provide ApiService instance for Products
    @Provides
    fun provideProductApiService(retrofit: Retrofit): ProductApiService {
        return retrofit.create(ProductApiService::class.java)
    }
}
