package com.league.assignmentjanitriandroidintern.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.league.assignmentjanitriandroidintern.model.ColorEntity

@Database(entities = [ColorEntity::class], version = 1)
abstract class ColorDatabase : RoomDatabase() {
    abstract fun colorDao(): ColorDao
}