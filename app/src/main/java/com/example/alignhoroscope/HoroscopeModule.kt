package com.example.alignhoroscope

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object HoroscopeModule {
    @Provides
    fun provideHoroscopeRepository(): HoroscopeRepository {
        return HoroscopeRepository()
    }
}
