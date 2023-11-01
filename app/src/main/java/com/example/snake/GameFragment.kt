package com.example.snake

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavController
import com.example.snake.domain.RecordManager
import com.example.snake.domain.SnakeViewModel
import com.example.snake.map.MapScreen

@Composable
fun GameFragment(navController: NavController, recordManager: RecordManager) {
    val snakeViewModel = SnakeViewModel(recordManager)
    LaunchedEffect(Unit) {
        snakeViewModel.generateApple()
        snakeViewModel.playNow()
    }
        MapScreen(navController, recordManager)
}