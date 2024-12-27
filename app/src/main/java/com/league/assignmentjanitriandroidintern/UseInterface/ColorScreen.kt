package com.league.assignmentjanitriandroidintern.UseInterface

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import com.league.assignmentjanitriandroidintern.model.ColorEntity
import com.league.assignmentjanitriandroidintern.viewModel.ColorViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ColorScreen(viewModel: ColorViewModel) {
    val colors by viewModel.colors.observeAsState(emptyList())
    val unsyncedCount by viewModel.unsyncedCount.observeAsState(0)

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Color App",
                    fontWeight = FontWeight.Bold,
                    color = Color.White) },
                actions = {
                    Text("Sync ($unsyncedCount)",
                        color = Color.White)
                    IconButton(onClick = { viewModel.syncColors() }) {
                        Icon(Icons.Default.Refresh, contentDescription = "Refresh", tint = Color.White)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF3F51B5)
                )
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { viewModel.addRandomColor() },
                containerColor = Color(0xFFB39DDB)
            ) {
                Icon(Icons.Default.Add, contentDescription = "Add Color")
            }
        }
    ) { padding ->
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.padding(padding)
        ) {
            items(colors.size) { color ->
                ColorCard(colors[color])
            }
        }
    }

    /* Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
         Text("Colors List", style = MaterialTheme.typography.bodyMedium)


         LazyVerticalGrid(
             columns = GridCells.Fixed(2),
             contentPadding = PaddingValues(16.dp),
             horizontalArrangement = Arrangement.spacedBy(16.dp),
             verticalArrangement = Arrangement.spacedBy(16.dp),

         ) {
             items(colors.size) { color ->
                 ColorCard(colors[color])
             }
         }
         LazyColumn(modifier = Modifier.weight(1f)) {
             items(colors.size) { color ->
                 ColorCard(colors[color])

                 }
         }

        Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
            Button(onClick = { viewModel.addRandomColor() }) {
                Text("Add Color")
            }
            Button(onClick = { viewModel.syncColors() }) {
                Text("Sync ($unsyncedCount)")
            }
        }
    }*/
}

@Composable
fun ColorCard(entity: ColorEntity) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(android.graphics.Color.parseColor(entity.colorCode)))
                .padding(16.dp)
        ) {
            Column {
                Text(
                    text = entity.colorCode,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.weight(1f))

                Text(
                    text = "Created at",
                    color = Color.White
                )
                Text(
                    text = entity.timestamp.toString(),
                    color = Color.White
                )
            }
        }
    }
}
