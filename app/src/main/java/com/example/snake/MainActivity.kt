package com.example.snake

import android.os.Bundle
import android.view.KeyEvent
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.snake.data.Direction

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(
                navController = navController,
                startDestination = "startScreen"
            ) {
                composable("startScreen") {
                    StartScreen(navController)
                }
                composable("gameScreen") {
                    GameFragment(navController)
                }
            }
        }
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        when (keyCode) {
            KeyEvent.KEYCODE_W -> if (currentDirection.value != Direction.DOWN) currentDirection.value = Direction.UP
            KeyEvent.KEYCODE_A -> if (currentDirection.value != Direction.RIGHT) currentDirection.value = Direction.LEFT
            KeyEvent.KEYCODE_S -> if (currentDirection.value != Direction.UP) currentDirection.value = Direction.DOWN
            KeyEvent.KEYCODE_D -> if (currentDirection.value != Direction.LEFT) currentDirection.value = Direction.RIGHT
        }
        return super.onKeyDown(keyCode, event)
    }
}