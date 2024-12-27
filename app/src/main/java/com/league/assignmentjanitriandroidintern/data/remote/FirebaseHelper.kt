package com.league.assignmentjanitriandroidintern.data.remote

import com.google.firebase.database.FirebaseDatabase
import com.league.assignmentjanitriandroidintern.model.ColorEntity
//test commit
class FirebaseHelper {
    private val database = FirebaseDatabase.getInstance().reference

    fun syncColors(
        colors: List<ColorEntity>,
        onSuccess: () -> Unit,
        onFailure: () -> Unit
    ) {
        colors.forEach { color ->
            database.child("colors").push().setValue(color)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        onSuccess()
                    } else {
                        onFailure()
                    }
                }
        }
    }
}