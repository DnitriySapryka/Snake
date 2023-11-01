package com.example.snake

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.snake.domain.RecordManager
import com.example.snake.domain.SnakeViewModel

@Composable
fun DeathDialog(status: String, navController: NavController,  recordManager: RecordManager) {
    val snakeViewModel = SnakeViewModel(recordManager)
    AlertDialog(

        onDismissRequest = {
            showDialogDead.value = false
            showDialogWin.value = false
                           },

        title = {Text(status)},

        text = {
            Text("Score: ${score.value}"
                    + "\nФайлов сьедино: ${applesCount.value}"
                    + "\nРазвитая скорость: Сначало научись двигаться плавно"
            )},

        confirmButton = {
            Button(
                onClick = {
                    showDialogDead.value = false
                    showDialogWin.value = false
                    tail.clear()
                    if (apples.isEmpty()) {snakeViewModel.generateApple()}
                    snakeViewModel.playNow()
                }, modifier = Modifier.fillMaxWidth()
            ) {
                Text("Играть еще")
            }
        },

        dismissButton = {
            Button(
                onClick = {
                    showDialogDead.value = false
                    showDialogWin.value = false
                    tail.clear()
                    apples.clear()
                    navController.navigate("startScreen")},
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Выйти в меню")
            }
        }
    )
}