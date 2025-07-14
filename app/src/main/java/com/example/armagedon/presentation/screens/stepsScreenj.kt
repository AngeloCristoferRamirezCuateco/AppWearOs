package com.example.armagedon.presentation.screens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.wear.compose.material.Text

@Composable
fun stepsWatch (navController: NavController){
    Box(
        modifier = Modifier
            .fillMaxSize()
    ){
        Canvas(modifier = Modifier.fillMaxSize()) {
            val center = Offset(size.width / 2, size.height / 2)
            val radius = size.minDimension / 2 - 10.dp.toPx() // Radio con margen
            val strokeWidth = 8.dp.toPx() // Grosor del anillo

            // Dibujar el fondo gris (1/4 del anillo)
            drawArc(
                color = Color.Gray,
                startAngle = 180f, // Comenzar desde arriba (12 en un reloj)
                sweepAngle = 90f,  // 90 grados = 1/4 del círculo
                useCenter = false,
                topLeft = Offset(center.x - radius, center.y - radius),
                size = Size(radius * 2, radius * 2),
                style = Stroke(strokeWidth)
            )

            // Dibujar la parte coloreada (3/4 del anillo)
            drawArc(
                color = Color(0xFFCCFC4B), // Azul de ejemplo
                startAngle = 270f,           // Comienza después del gris (270° + 90° = 0°)
                sweepAngle = 270f,         // 270 grados = 3/4 del círculo
                useCenter = false,
                topLeft = Offset(center.x - radius, center.y - radius),
                size = Size(radius * 2, radius * 2),
                style = Stroke(strokeWidth)
            )
        }
        Text(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(40.dp),
            text = "Steps",
            color = Color(0xFFCCFC4B),
        )
        Text(
            modifier = Modifier
                .align(Alignment.Center),
            text = "6562",
            fontSize = 50.sp
        )
        Text(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(40.dp),
            text = "/ 8000")
    }
}