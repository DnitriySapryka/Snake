package com.example.snake.map.components

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
fun PartBody(modifier: Modifier, background: Color = Color.Transparent, shape: Shape = RoundedCornerShape(5), c: @Composable ()->Unit) {

    Box(
        modifier = modifier
            .clip(shape = shape)
            .background(color = background)
            .size(block.dp)
    ) {
        c()
    }


}
