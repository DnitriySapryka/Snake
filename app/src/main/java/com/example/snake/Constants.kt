package com.example.snake

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.example.snake.data.Direction
import com.example.snake.data.SnakeSegment
import kotlinx.coroutines.Job

// todo сделать на координатах
// var x = mutableStateOf(0)
// var y = mutableStateOf(0)

var isClicked = mutableStateOf(false)

var showDialog = mutableStateOf(false)

const val defaultPosition = 0
var block = 38
var verticalBlock = 12
var horizontalBlock = 10
var record = mutableStateOf(0)

val tail = mutableListOf<SnakeSegment>()
val applesCount = mutableStateOf(0)
val apples = mutableListOf<SnakeSegment>()

val horizontalPosition = mutableStateOf(0)
val verticalPosition = mutableStateOf(0)

val score = mutableStateOf(0)
var snakeSpeed = mutableStateOf(1000L)

val currentDirection = mutableStateOf(Direction.RIGHT)