package com.league.assignmentjanitriandroidintern.UseInterface

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.viewmodel.compose.viewModel
import com.league.assignmentjanitriandroidintern.viewModel.ColorViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            val viewModel: ColorViewModel = viewModel()
            ColorScreen(viewModel)
        }
    }
}