package com.example.snake.mySnake

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import com.example.snake.block

@Composable
fun Head(modifier: Modifier, background: Color = Color(0xFFCAA533), shape: Shape = RoundedCornerShape(5)) {

    Box(
        modifier = modifier
            .clip(shape = shape)
            .background(color = background)
            .size(block.dp)
    )


}
