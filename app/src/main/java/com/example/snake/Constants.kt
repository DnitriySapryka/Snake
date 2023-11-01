package com.example.snake

import androidx.compose.runtime.mutableStateOf
import com.example.snake.data.Direction
import com.example.snake.data.SnakeSegment

// todo сделать на координатах
// var x = mutableStateOf(0)
// var y = mutableStateOf(0)

var isClicked = mutableStateOf(false)

var showDialogDead = mutableStateOf(false)
var showDialogWin = mutableStateOf(false)

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
var snakeSpeed = mutableStateOf(600L)

val currentDirection = mutableStateOf(Direction.RIGHT)