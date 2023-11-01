package com.example.snake.map.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.snake.R
import com.example.snake.block
import com.example.snake.data.SnakeSegment

@Composable
fun Apples(
    apples: List<SnakeSegment>,
    currentHorizontal: Int,
    currentVertical: Int
) {
    if (apples.isNotEmpty()) {
        apples.forEach { apple ->
            Apple(
                horizontal = apple.horizontal,
                vertical = apple.vertical,
                currentHorizontal = currentHorizontal,
                currentVertical = currentVertical
            )
        }
    }
}

@Composable
fun Apple(
    horizontal: Int,
    vertical: Int,
    currentHorizontal: Int,
    currentVertical: Int
) {
    PartBody(
        modifier = Modifier.padding(
            top = vertical.dp,
            start = horizontal.dp,
        ), shape = CircleShape
    ) {
        if (horizontal != currentHorizontal || vertical != currentVertical) {
            Image(
                painter = painterResource(id = R.drawable.disk_svgrepo_com),
                contentDescription = "яблоко",
                modifier = Modifier.size(block.dp)
            )
        }
    }
}