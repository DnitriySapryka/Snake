package com.example.snake

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavController
import com.example.snake.map.MapScreen

@Composable
fun GameFragment(navController: NavController) {
    val snakeViewModel = SnakeViewModel()
    LaunchedEffect(Unit) {
        snakeViewModel.generateApple()
        snakeViewModel.playNow()
    }
        MapScreen(navController)
}