package com.league.assignmentjanitriandroidintern.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.league.assignmentjanitriandroidintern.model.ColorEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ColorDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertColor(color: ColorEntity)

    @Query("SELECT * FROM colors")
    fun getAllColors(): Flow<List<ColorEntity>>

    @Query("SELECT * FROM colors WHERE synced = false")
    fun getUnsyncedColors(): List<ColorEntity>

    @Query("UPDATE colors SET synced = true WHERE id IN (:ids)")
    suspend fun updateSyncedColors(ids: List<Int>)
}