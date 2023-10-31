package com.example.snake.map.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.snake.horizontalBlock
import com.example.snake.verticalBlock

@Composable
fun Map() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color(0xFFC2780B)),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            for (row in 0 until verticalBlock) {
                Row(
                    horizontalArrangement = Arrangement.Center
                ) {
                    for (bloc in 0 until horizontalBlock) {
                        ItemForMap()
                    }
                }
            }
        }
    }

}