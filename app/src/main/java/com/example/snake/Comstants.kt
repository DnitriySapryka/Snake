package com.example.snake

import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.unit.dp

// todo сделать на координатах
// var x = mutableStateOf(0)
// var y = mutableStateOf(0)

const val defaultPosition = 0
const val block = 20
const val verticalBlock = 18
const val horizontalBlock = 18


val tail = mutableListOf<SnakeSegment>()
val apples = mutableListOf<SnakeSegment>()
val prevPos = mutableStateOf(SnakeSegment(0, 0))


val horizontalPosition = mutableStateOf(0)
val verticalPosition = mutableStateOf(0)

var snakeLength = 0

val currentDirection = mutableStateOf(Direction.RIGHT)