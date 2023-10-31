package com.example.snake

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable


@Composable
fun DeathDialog() {
    val snakeViewModel = SnakeViewModel()
    AlertDialog(
        onDismissRequest = {
            showDialog.value = false
        },

        title = { Text("Ты проиграл" +
                "\nScore: ${score.value}" +
                "\nФайлов сьедино: Я не считал" +
                "\nРазвитая скорость: Сначало научись двигаться плавно")},
        confirmButton = {
            Button(
                onClick = {
                    showDialog.value = false
                    snakeViewModel.playNow()
                }
            ) {
                Text("Играть еще")
            }
        },
        dismissButton = {
            Button(
                onClick = {
                    showDialog.value = false
                }
            ) {
                Text("Выйти в меню")
            }
        }
    )
}