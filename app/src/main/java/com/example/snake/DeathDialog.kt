package com.example.snake

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun DeathDialog(navController: NavController) {
    val snakeViewModel = SnakeViewModel()
    AlertDialog(

        onDismissRequest = {
            showDialog.value = false
                           },

        title = {Text("Ты проиграл")},

        text = {
            Text("Score: ${score.value}"
                    + "\nФайлов сьедино: ${applesCount.value}"
                    + "\nРазвитая скорость: Сначало научись двигаться плавно"
            )},

        confirmButton = {
            Button(
                onClick = {
                    showDialog.value = false
                    snakeViewModel.playNow()
                }, modifier = Modifier.fillMaxWidth()
            ) {
                Text("Играть еще")
            }
        },

        dismissButton = {
            Button(
                onClick = {
                    showDialog.value = false
                    apples.clear()
                    navController.navigate("startScreen")},
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Выйти в меню")
            }
        }
    )
}