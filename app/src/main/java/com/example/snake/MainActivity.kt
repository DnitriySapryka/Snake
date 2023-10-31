package com.example.snake

import android.os.Bundle
import android.view.KeyEvent
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.snake.data.Direction
import com.example.snake.map.MapScreen
import com.example.snake.ui.theme.SnakeTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    private val snakeViewModel = SnakeViewModel()
    private var snakeJob: Job? = null // Переменная для хранения корутины

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        snakeViewModel.generateApple()

        setContent {

//            val navController = rememberNavController()
//
//            NavHost(
//                navController = navController,
//                startDestination = "startScreenFragment"
//            ) {
//                composable("startScreenFragment") {
//                    StartScreen(navController)
//                }
//                composable("gameFragment") {
//                    GameFragment()
//                }
//            }

            SnakeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    MapScreen ()

                    val startCoroutine = {
                        snakeJob = CoroutineScope(Dispatchers.Default).launch {
                            while (true) {
                                delay(snakeSpeed.value)
                                snakeViewModel.moveSnake()
                                snakeViewModel.verticalControl()
                                snakeViewModel.horizontalControl()

                                // Проверка на столкновение и остановка корутины
                                if (snakeViewModel.dtp()) {
                                    snakeJob?.cancel() // Остановка корутины при столкновении
                                }
                            }
                        }
                    }

                    LaunchedEffect(key1 = Unit) {
                        startCoroutine()
                    }
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

