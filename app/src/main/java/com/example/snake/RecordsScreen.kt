package com.example.snake

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.snake.domain.RecordManager

@Composable
fun RecordsScreen(recordManager: RecordManager, navController: NavController) {
    val records = recordManager.getRecords()

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Рекорды", fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(16.dp))
        if (records.isNotEmpty()) {
            LazyColumn {
                items(records) { record ->
                    Text(
                        text = "Рекорд: $record",
                        fontSize = 18.sp
                    )
                }
            }
        } else {
            Text(text = "Пока нет рекордов", fontSize = 18.sp)
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { navController.navigate("startScreen") },
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = "Вернуться в меню")
        }
    }
}