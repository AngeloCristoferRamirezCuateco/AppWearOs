package com.example.armagedon.presentation.screens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import kotlinx.coroutines.delay
import java.time.LocalTime
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.Text
import androidx.wear.compose.material.Icon
import kotlin.math.cos
import kotlin.math.sin
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.automirrored.filled.DirectionsWalk
import androidx.compose.material.icons.filled.DirectionsWalk
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.graphics.StrokeCap
import androidx.navigation.NavController

@Composable
fun AnalogWatchFaceExample(navController: NavController) {
    val time = remember { mutableStateOf(LocalTime.now()) }

    // Update every second
    LaunchedEffect(Unit) {
        while (true) {
            time.value = LocalTime.now()
            delay(1000L)
        }
    }

    val hour = time.value.hour % 12
    val minute = time.value.minute
    val second = time.value.second

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        contentAlignment = Alignment.Center
    ) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            val center = Offset(size.width / 2, size.height / 2)
            val radius = size.minDimension / 2

            // Draw clock ticks
            for (i in 0 until 60) {
                val angle = Math.toRadians(i * 6.0 - 90)
                val start = Offset(
                    x = center.x + cos(angle).toFloat() * radius * 0.9f,
                    y = center.y + sin(angle).toFloat() * radius * 0.9f
                )
                val end = Offset(
                    x = center.x + cos(angle).toFloat() * radius,
                    y = center.y + sin(angle).toFloat() * radius
                )
                drawLine(
                    color = Color.White,
                    start = start,
                    end = end,
                    strokeWidth = if (i % 5 == 0) 4f else 2f
                )
            }

            // Hour hand
            val hourAngle = Math.toRadians((hour + minute / 60f) * 30 - 90.0)
            drawLine(
                color = Color(0xFFCCFF00),
                start = center,
                end = Offset(
                    x = center.x + cos(hourAngle).toFloat() * radius * 0.4f,
                    y = center.y + sin(hourAngle).toFloat() * radius * 0.4f
                ),
                strokeWidth = 12f,
                cap = StrokeCap.Round
            )

            // Minute hand
            val minuteAngle = Math.toRadians((minute + second / 60f) * 6 - 90.0)
            drawLine(
                color = Color(0xFFCCFF00),
                start = center,
                end = Offset(
                    x = center.x + cos(minuteAngle).toFloat() * radius * 0.6f,
                    y = center.y + sin(minuteAngle).toFloat() * radius * 0.6f
                ),
                strokeWidth = 8f,
                cap = StrokeCap.Round
            )

            // Second hand
            val secondAngle = Math.toRadians(second * 6.0 - 90)
            drawLine(
                color = Color.White,
                start = center,
                end = Offset(
                    x = center.x + cos(secondAngle).toFloat() * radius * 0.75f,
                    y = center.y + sin(secondAngle).toFloat() * radius * 0.75f
                ),
                strokeWidth = 2f,
                cap = StrokeCap.Round
            )
        }

        // Step Counter Display
        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                imageVector = Icons.Default.DirectionsWalk,
                contentDescription = "Steps",
                tint = Color(0xFFCCFF00)
            )
            Text("7.5K", color = Color.White)
        }
    }
}
