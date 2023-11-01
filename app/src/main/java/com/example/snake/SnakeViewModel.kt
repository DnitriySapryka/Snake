package com.example.snake

import androidx.lifecycle.ViewModel
import com.example.snake.data.Direction
import com.example.snake.data.SnakeSegment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SnakeViewModel:ViewModel() {
    private var snakeJob: Job? = null // Переменная для хранения корутины

    fun playNow() {
        if (snakeJob?.isActive != true) { // Проверка, что корутина не активна
            horizontalPosition.value = 0
            verticalPosition.value = 0
            currentDirection.value = Direction.RIGHT
            score.value = 0

            snakeJob = CoroutineScope(Dispatchers.Default).launch {
                while (true) {
                    delay(snakeSpeed.value)
                    moveSnake()
                    verticalControl()
                    horizontalControl()
                    if (dtp()) {
                        // В этом месте можно добавить логику после столкновения, если необходимо
                        return@launch // Завершаем корутину при столкновении
                    }
                }
            }
        }
    }

    fun generateApple() {
        if (tail.size != horizontalBlock * verticalBlock - 1) {
            var randomX = (0 until horizontalBlock).random() * block
            var randomY = (0 until verticalBlock).random() * block
            while (tail.contains(SnakeSegment(randomX, randomY))) {
                randomX = (0 until horizontalBlock).random() * block
                randomY = (0 until verticalBlock).random() * block
            }
            apples.add(SnakeSegment(randomX, randomY))
        }
        else {
            applesCount.value = tail.size
            snakeSpeed.value = 600
            showDialogWin.value = true
            snakeJob?.cancel()
        }
    }

    fun dtp(): Boolean {
        if (tail.contains(SnakeSegment(horizontalPosition.value, verticalPosition.value))) {
            applesCount.value = tail.size
//            tail.clear()
            if (score.value > record.value) { record.value = score.value}
            snakeSpeed.value = 600
            showDialogDead.value = true
            return true // Возвращаем true, чтобы указать о столкновении
        }
        return false // Возвращаем false, если столкновение не произошло
    }

    fun checkCollisionWithApple(eatFail: ()-> Unit) {
        val headPosition = SnakeSegment(horizontalPosition.value, verticalPosition.value)
        val eatenApple = apples.find { it == headPosition }
        if (eatenApple != null) {
            if (snakeSpeed.value > 200) {
                if (snakeSpeed.value < 400) {
                    snakeSpeed.value -= 5
                } else {
                    snakeSpeed.value -= 10
                }
            }
            else snakeSpeed.value = 200
            score.value += 10 * tail.size
            apples.remove(eatenApple)
            if (apples.isEmpty()) {
                generateApple()
            }
        } else {
            eatFail.invoke()
        }
    }

    fun verticalControl() {
        when {
            verticalPosition.value < defaultPosition  -> verticalPosition.value = (verticalBlock - 1) * block
            verticalPosition.value > (verticalBlock - 1) * block -> verticalPosition.value = defaultPosition
        }
    }

    fun horizontalControl() {
        when {
            horizontalPosition.value < defaultPosition  -> horizontalPosition.value = (horizontalBlock - 1) * block
            horizontalPosition.value > (horizontalBlock - 1) * block -> horizontalPosition.value = defaultPosition
        }
    }

    fun moveSnake() {
        dtp()
        addCurrentPosToTail()
        checkCollisionWithApple() {
            tail.removeAt(0)
        }
        moveSnakeInDirection()
    }
}

fun moveSnakeInDirection() {
    when (currentDirection.value) {
        Direction.UP -> verticalPosition.value -= block
        Direction.DOWN -> verticalPosition.value += block
        Direction.LEFT -> horizontalPosition.value -= block
        Direction.RIGHT -> horizontalPosition.value += block
    }
}

fun addCurrentPosToTail() {
    tail.add(SnakeSegment(horizontalPosition.value, verticalPosition.value))
}