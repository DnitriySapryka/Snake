package com.example.snake

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController


@Composable
fun StartScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Gray),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround
    ) {
        ItemCard("Играть", R.drawable.play_snake) {navController.navigate("gameScreen")}
        ItemCard("Рейтинг", R.drawable.raiting) {navController.navigate("recordsScreen")}
        ItemCard("Нстройки", R.drawable.settings) {}
    }
}

@Composable
fun ItemCard(label: String, image: Int, navigate: () -> Unit) {


    Card(
        modifier = Modifier
            .padding(horizontal = 40.dp)
            .fillMaxWidth()
            .height(240.dp)
            .clip(shape = RoundedCornerShape(20.dp))
            .clickable {
                isClicked.value = !isClicked.value
                if (isClicked.value) {
                    // Действия при клике
                    navigate()
                }
            },

    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = image),
                contentDescription = "image",
                contentScale = if (isClicked.value) ContentScale.Crop else ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
            )
            Text(
                text = label,
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(top = 120.dp)
                ,
                style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight(500)
                )
            )
        }
    }
}