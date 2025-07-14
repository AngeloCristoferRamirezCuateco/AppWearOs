package com.example.armagedon.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.runtime.Composable
import java.time.LocalTime
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.Text
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import java.time.format.DateTimeFormatter

@Composable
fun SpeedDistanceScreen(
    navController: NavController,
    maxSpeed: Double = 46.5,
    distance: Double = 21.8,
    time: String = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm"))
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(8.dp)
    ) {
        // Hora en la parte superior centrada
        Text(
            text = time,
            color = Color.White,
            fontSize = 14.sp,
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 8.dp)
        )

        // Datos principales en el centro
        Row(
            modifier = Modifier
                .align(Alignment.Center)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text("Max Spd", color = Color.LightGray, fontSize = 14.sp)
                Text(
                    text = "$maxSpeed",
                    color = Color.White,
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold
                )
                Text("mph", color = Color.LightGray, fontSize = 12.sp)
            }

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text("Distance", color = Color.LightGray, fontSize = 14.sp)
                Text(
                    text = "$distance",
                    color = Color.White,
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold
                )
                Text("mile", color = Color.LightGray, fontSize = 12.sp)
            }
        }
    }
}
