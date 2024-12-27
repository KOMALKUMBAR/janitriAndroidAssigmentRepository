package com.league.assignmentjanitriandroidintern.viewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import com.league.assignmentjanitriandroidintern.data.local.ColorDatabase
import com.league.assignmentjanitriandroidintern.data.remote.FirebaseHelper
import com.league.assignmentjanitriandroidintern.model.ColorEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ColorViewModel(application: Application) : AndroidViewModel(application) {
    private val db = Room.databaseBuilder(application, ColorDatabase::class.java, "color_db").build()
    private val firebaseHelper = FirebaseHelper()

    val colors: LiveData<List<ColorEntity>> = db.colorDao().getAllColors().asLiveData()
    val unsyncedCount = MutableLiveData<Int>()

    init {
        refreshUnsyncedCount()
    }

    fun addRandomColor() {
        val newColor = ColorEntity(colorCode = "#${(100000..999999).random()}", timestamp = System.currentTimeMillis())
        viewModelScope.launch {
            db.colorDao().insertColor(newColor)
            refreshUnsyncedCount()
        }
    }

    fun syncColors() {
        viewModelScope.launch(Dispatchers.IO) {
            val unsyncedColors = db.colorDao().getUnsyncedColors()
            firebaseHelper.syncColors(
                unsyncedColors,
                onSuccess = {
                    val ids = unsyncedColors.map { it.id }
                    viewModelScope.launch {
                        db.colorDao().updateSyncedColors(ids)
                        refreshUnsyncedCount()
                    }
                },
                onFailure = {
                    Log.e("TAG", "syncColors: hey error here", )
                    // Handle failure
                }
            )
        }
    }

    private fun refreshUnsyncedCount() {
        viewModelScope.launch (Dispatchers.IO){
            unsyncedCount.postValue(db.colorDao().getUnsyncedColors().size)
        }
    }
}