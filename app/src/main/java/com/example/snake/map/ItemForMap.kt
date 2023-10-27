package com.example.snake.map

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.snake.block

@Composable
fun ItemForMap() {
    Box(
        modifier = Modifier
            .size(block.dp)
            .background(Color.Gray)
            .border(1.dp, Color.Black)
    )
}