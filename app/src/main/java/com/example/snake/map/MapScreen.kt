package com.example.snake.map

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.snake.R
import com.example.snake.data.SnakeSegment
import com.example.snake.apples
import com.example.snake.block
import com.example.snake.currentDirection
import com.example.snake.data.Direction
import com.example.snake.horizontalPosition
import com.example.snake.map.components.Map
import com.example.snake.map.components.PartBody
import com.example.snake.pult.Pult
import com.example.snake.score
import com.example.snake.showDialog
import com.example.snake.tail
import com.example.snake.DeathDialog
import com.example.snake.record
import com.example.snake.verticalPosition

@Composable
fun MapScreen(navController: NavController) {

    if (showDialog.value){
        DeathDialog(navController)
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom,
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 80.dp)
        ) {
            Text(text = "Score: ${score.value}")
            Text(text = "Record: ${record.value}")
        }
        Box(
            modifier = Modifier
                .background(Color.Blue),
        ) {
            Map()

            //body
            if (tail.isNotEmpty()) {
                tail.forEach { tail ->
                    PartBody(
                        modifier = Modifier.padding(
                            top = (tail.vertical).dp,
                            start = (tail.horizontal).dp,
                        ),
                        shape = RoundedCornerShape(10.dp),
                        background = Color.Green
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.tail),
                            contentDescription = "body"
                        )
                    }
                }
            }

            //head
            PartBody(
                modifier = Modifier
                    .padding(
                        top = verticalPosition.value.dp,
                        start = horizontalPosition.value.dp,
                    )
                    .rotate(
                        when (currentDirection.value) {
                            Direction.DOWN -> 90f
                            Direction.UP -> 270f
                            else -> {
                                0f
                            }
                        }
                    )
                    .scale(
                        scaleX = when (currentDirection.value) {
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
            //apple
            if (apples.isNotEmpty()) {
                apples.forEach { apple ->
                    PartBody(
                        modifier = Modifier.padding(
                            top = apple.vertical.dp,
                            start = apple.horizontal.dp,
                        ), shape = CircleShape
                    ) {
                        if (apple != SnakeSegment(
                                horizontalPosition.value,
                                verticalPosition.value
                            )
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.disk_svgrepo_com),
                                contentDescription = "яблоко",
                                modifier = Modifier.size(block.dp)
                            )
                        }
                    }
                }
            }
        }
        Pult()
    }
}