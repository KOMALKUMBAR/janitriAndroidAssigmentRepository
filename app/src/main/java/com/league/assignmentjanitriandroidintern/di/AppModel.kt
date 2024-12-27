package com.league.assignmentjanitriandroidintern.di

import android.content.Context
import androidx.room.Room
import com.league.assignmentjanitriandroidintern.data.local.ColorDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(context: Context): ColorDatabase {
        return Room.databaseBuilder(context, ColorDatabase::class.java, "color_db").build()
    }
}
