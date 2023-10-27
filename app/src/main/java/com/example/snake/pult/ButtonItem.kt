package com.example.snake.pult

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun ButtonItem(onClick: () -> Unit, icon: ImageVector) {
    Button(
        modifier = Modifier
            .size(80.dp),
        onClick = onClick,
        content = { Icon(imageVector = icon, contentDescription = "icon for button")}
    )
}
