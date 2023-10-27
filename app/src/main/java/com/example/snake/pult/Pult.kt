package com.example.snake.pult

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
import androidx.compose.ui.unit.dp
import com.example.snake.Direction
import com.example.snake.block
import com.example.snake.currentDirection
import com.example.snake.defaultPosition
import com.example.snake.horizontalBlock
import com.example.snake.horizontalPosition
import com.example.snake.verticalBlock
import com.example.snake.verticalPosition

@Composable
fun Pult() {
    Row(
        modifier = Modifier
            .padding(top = 40.dp)
            .height(240.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        ButtonItem(
            onClick = { currentDirection.value = Direction.LEFT},
            icon = Icons.Default.KeyboardArrowLeft)

        Column {
            ButtonItem(
                onClick = { currentDirection.value = Direction.UP },
                icon = Icons.Default.KeyboardArrowUp)

            Box(modifier = Modifier.height(80.dp))

            ButtonItem(
                onClick = { currentDirection.value = Direction.DOWN },
                icon = Icons.Default.KeyboardArrowDown)
        }

        ButtonItem(
            onClick = { currentDirection.value = Direction.RIGHT },
            icon = Icons.Default.KeyboardArrowRight)
    }
}

fun verticalControl() {
    when {
        verticalPosition.value < defaultPosition  -> verticalPosition.value = (verticalBlock - 1) * block
        verticalPosition.value > (verticalBlock - 1) * block -> verticalPosition.value = defaultPosition
    }
}

fun horizontalControl() {
    when {
        horizontalPosition.value < defaultPosition  -> horizontalPosition.value = (horizontalBlock - 1) * block
        horizontalPosition.value > (horizontalBlock - 1) * block -> horizontalPosition.value = defaultPosition
    }
}

