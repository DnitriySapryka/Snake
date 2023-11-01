package com.example.snake.map

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.snake.apples
import com.example.snake.currentDirection
import com.example.snake.horizontalPosition
import com.example.snake.map.components.Map
import com.example.snake.pult.Pult
import com.example.snake.score
import com.example.snake.showDialogDead
import com.example.snake.tail
import com.example.snake.DeathDialog
import com.example.snake.domain.RecordManager
import com.example.snake.map.components.Apples
import com.example.snake.map.components.Body
import com.example.snake.map.components.Head
import com.example.snake.record
import com.example.snake.showDialogWin
import com.example.snake.verticalPosition

@Composable
fun MapScreen(navController: NavController, recordManager: RecordManager) {

    if (showDialogDead.value){
        DeathDialog("Ты проиграл (", navController, recordManager)
    }
    if (showDialogWin.value){
        DeathDialog("Ты победил!", navController, recordManager)
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom,
        modifier = Modifier.fillMaxHeight()
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
                    Body(tail = tail)
                }
            }
            //head
            Head(
                horizontalPosition = horizontalPosition.value,
                verticalPosition = verticalPosition.value,
                currentDirection = currentDirection.value
            )
            //apple
            Apples(
                apples = apples,
                currentHorizontal = horizontalPosition.value,
                currentVertical = verticalPosition.value
            )
        }
        Pult()
    }
}