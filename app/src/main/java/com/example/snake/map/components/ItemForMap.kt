package com.example.snake.map.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.snake.R
import com.example.snake.block

@Composable
fun ItemForMap() {
    Box {
        Image(
            painter = painterResource(id = R.drawable.pol),
            contentDescription = "трава",
            modifier = Modifier
                .size(block.dp),
            contentScale = ContentScale.FillBounds
        )
    }
}