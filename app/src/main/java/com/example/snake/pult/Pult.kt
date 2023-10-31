package com.example.snake.pult

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.snake.currentDirection
import com.example.snake.data.Direction

@Composable
fun Pult() {
    Box(
        modifier = Modifier.background(color = Color(0xFFC2780B))
    ) {
        Row(
            modifier = Modifier
                .padding(vertical = 40.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            ButtonItem(
                onClick = { if (currentDirection.value != Direction.RIGHT) {currentDirection.value = Direction.LEFT }},
                icon = Icons.Default.KeyboardArrowLeft)

            Column {
                ButtonItem(
                    onClick = { if (currentDirection.value != Direction.DOWN) {currentDirection.value = Direction.UP}},
                    icon = Icons.Default.KeyboardArrowUp)

                Box(modifier = Modifier.height(80.dp))

                ButtonItem(
                    onClick = { if (currentDirection.value != Direction.UP) {currentDirection.value = Direction.DOWN }},
                    icon = Icons.Default.KeyboardArrowDown)
            }

            ButtonItem(
                onClick = { if (currentDirection.value != Direction.LEFT) {currentDirection.value = Direction.RIGHT }},
                icon = Icons.Default.KeyboardArrowRight)
        }
    }

}

