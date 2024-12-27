package com.league.assignmentjanitriandroidintern.model

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "colors")
data class ColorEntity(@PrimaryKey(autoGenerate = true) val id: Int = 0,
                       val colorCode: String,
                       val timestamp: Long,
                       val synced: Boolean = false)
