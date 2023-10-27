package com.example.snake.map

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.snake.horizontalBlock
import com.example.snake.pult.Pult
import com.example.snake.verticalBlock

@Composable
fun Map(content: @Composable () -> Unit) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .padding(top = 16.dp)
                .size(40.dp * 9),
            ) {
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                for (row in 0 until verticalBlock) {
                    Row(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        for (bloc in 0 until horizontalBlock) {
                            ItemForMap()
                        }
                    }
                }
            }
            content()
        }
        Pult()
    }
}


