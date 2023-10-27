package com.example.snake

import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.snake.map.Map
import com.example.snake.mySnake.Head
import com.example.snake.pult.horizontalControl
import com.example.snake.pult.verticalControl
import com.example.snake.ui.theme.SnakeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        generateApple()
        setContent {
            SnakeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    Map {
                        if (tail.isNotEmpty()) {
                            tail.forEach { tail ->
                                Head(
                                    modifier = Modifier.padding(
                                        top = (tail.vertical).dp,
                                        start = (tail.horizontal).dp,
                                    ),
                                    background = Color.Blue
                                ) {

                                }
                            }
                        }
                        Head(
                            modifier = Modifier.padding(
                                    top = verticalPosition.value.dp,
                                    start = horizontalPosition.value.dp,
                                )
                                ,
                            background = Color.Yellow
                        ){}
                        if (apples.isNotEmpty()) {
                            apples.forEach { apple ->
                                Head(
                                    modifier = Modifier.padding(
                                        top = apple.vertical.dp,
                                        start = apple.horizontal.dp,
                                    ),
                                    shape = CircleShape
                                ) {
                                    Icon(
                                    painter = painterResource(id = R.drawable.apple),
                                    contentDescription = "яблоко",
                                    tint = Color.Red,
                                    modifier = Modifier
                                        .size(block.dp)
                                    )
                                }
                            }
                        }
                    }
                    Thread(Runnable {
                        while (true) {
                            Thread.sleep(200) // Установите интервал между шагами змейки
                            runOnUiThread {
                                moveSnake()
                                verticalControl()
                                horizontalControl()
                            }
                        }
                    }).start()
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

// 1 сделай еще один список как "хвост", но для яблок
// 2 они должны рандомно раскидываться по пустым клеткам на карте
// 3 при столкновении головы змеи с элементом из списка "яблоки" в "хвост" добавляется элемент, а из "яблок удаляется"
// 4 при столкновении головы с элементом из списка "хвост" игра заканчивается

// СТОЛКНОВЕНИЕ - когда [SnakeSegment] из списков равны

fun generateApple() {
    var randomX = (0 until horizontalBlock).random() * block
    var randomY = (0 until verticalBlock).random() * block
    while (tail.contains(SnakeSegment(randomX, randomY))) {
        randomX = (0 until horizontalBlock).random() * block
        randomY = (0 until verticalBlock).random() * block
    }
    apples.add(SnakeSegment(randomX, randomY))
}

fun dtp() {
    if (tail.contains(SnakeSegment(horizontalPosition.value, verticalPosition.value))) {

        Log.e("snake", "Tail detected!")
        tail.clear()
        snakeLength = 0
    }
}

fun checkCollisionWithApple() {
    val headPosition = SnakeSegment(horizontalPosition.value, verticalPosition.value)
    val eatenApple = apples.find { it == headPosition }
    if (eatenApple != null) {

        snakeLength++

        tail.add(eatenApple) // Добавляем позицию яблока в хвост

        apples.remove(eatenApple) // Удаляем съеденное яблоко из списка яблок

        if (apples.isEmpty()) {
            repeat(tail.size) {
                generateApple() // Генерируем новое яблоко
            }
        }
    }
}



fun moveSnake() {

    dtp()
    tail.add(SnakeSegment(horizontalPosition.value, verticalPosition.value))

    if (tail.size > snakeLength) {
        tail.removeAt(0)
    }

    checkCollisionWithApple()

    when (currentDirection.value) {
        Direction.UP -> verticalPosition.value -= block
        Direction.DOWN -> verticalPosition.value += block
        Direction.LEFT -> horizontalPosition.value -= block
        Direction.RIGHT -> horizontalPosition.value += block
    }

    //Log.e("snake", "x=${horizontalPosition.value}y=${verticalPosition.value}")
    //Log.e("snake", "${tail}")
}

enum class Direction {
    UP,
    DOWN,
    RIGHT,
    LEFT
}
