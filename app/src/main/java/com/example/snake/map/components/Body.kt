package com.example.snake.map.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.snake.R
import com.example.snake.data.SnakeSegment

@Composable
fun Body(tail: SnakeSegment) {
    PartBody(
        modifier = Modifier.padding(
            top = (tail.vertical).dp,
            start = (tail.horizontal).dp,
        ), shape = RoundedCornerShape(10.dp), background = Color.Green
    ) {
        Image(
            painter = painterResource(id = R.drawable.tail), contentDescription = "body"
        )
    }
}