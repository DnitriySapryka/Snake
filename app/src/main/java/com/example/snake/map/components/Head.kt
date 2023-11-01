package com.example.snake.map.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.snake.R
import com.example.snake.data.Direction

@Composable
fun Head(
    horizontalPosition: Int,
    verticalPosition: Int,
    currentDirection: Direction
) {
    PartBody(
        modifier = Modifier
            .padding(
                top = verticalPosition.dp,
                start = horizontalPosition.dp,
            )
            .rotate(
                when (currentDirection) {
                    Direction.DOWN -> 90f
                    Direction.UP -> 270f
                    else -> {
                        0f
                    }
                }
            )
            .scale(
                scaleX = when (currentDirection) {
                    Direction.LEFT -> (-1f)
                    else -> 1f
                }, scaleY = 1f
            ),
        shape = RoundedCornerShape(10.dp),
        background = Color.Green
    ) {
        Image(painter = painterResource(id = R.drawable.venom), contentDescription = "head",
            modifier = Modifier.rotate(270f))
    }
}