package com.example.armagedon.presentation.screens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.*
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.wear.compose.material.Button
import androidx.wear.compose.material.ButtonDefaults
import androidx.wear.compose.material.Text
import kotlinx.coroutines.delay
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.wear.compose.material.*
import kotlinx.coroutines.delay
import kotlin.random.Random

@Composable
fun FlappyBirdScreen(onBack: () -> Unit) {
    var gameSessionId by remember { mutableStateOf(0) }
    val density = LocalDensity.current
    var gameStarted by remember { mutableStateOf(false) }
    var gameOver by remember { mutableStateOf(false) }
    var score by remember { mutableStateOf(0) }

    val birdRadius = with(density) { 14.dp.toPx() }
    val tubeWidthFraction = 0.1f
    val gapHeightFraction = 0.4f

    var birdY by remember { mutableStateOf(0.5f) }
    var birdVelocity by remember { mutableStateOf(0f) }
    val gravity = 0.0003f
    val jumpForce = -0.010f

    val safeMargin = 0.05f
    val minY = safeMargin
    val maxY = 1f - safeMargin

    var tubes by remember { mutableStateOf(emptyList<Pair<Float, Float>>()) }
    val tubeSpeed = 0.0035f
    var lastTubeTime by remember { mutableStateOf(0L) }

    LaunchedEffect(gameSessionId) {
        if (gameStarted && !gameOver) {
            while (true) {
                val currentTime = System.currentTimeMillis()

                birdVelocity += gravity
                birdY += birdVelocity

                if (birdY < minY) {
                    birdY = minY
                    birdVelocity = 0f
                }
                if (birdY > maxY) {
                    gameOver = true
                    break
                }

                if (currentTime - lastTubeTime > 2000L) {
                    tubes = tubes + Pair(
                        1.3f,
                        Random.nextFloat() * (1f - gapHeightFraction - 2 * safeMargin) + safeMargin
                    )
                    lastTubeTime = currentTime
                }

                tubes = tubes.map { (x, gapY) ->
                    Pair(x - tubeSpeed, gapY)
                }.filter { (x, _) -> x > -0.3f }

                tubes.firstOrNull { (x, _) ->
                    x < 0.4f && x + tubeSpeed >= 0.4f
                }?.let { score++ }

                val birdX = 0.35f
                val hitTube = tubes.any { (x, gapY) ->
                    x < birdX + tubeWidthFraction &&
                            x + tubeWidthFraction > birdX - tubeWidthFraction &&
                            (birdY < gapY || birdY > gapY + gapHeightFraction)
                }

                if (hitTube) {
                    gameOver = true
                    break
                }

                delay(16)
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF95F2EB))
    ) {
        Box(
            modifier = Modifier
                .weight(0.85f)
                .fillMaxWidth()
        ) {
            Canvas(modifier = Modifier.fillMaxSize()) {
                val width = size.width
                val height = size.height

                drawCircle(
                    color = Color.Yellow,
                    center = Offset(width * 0.35f, height * birdY),
                    radius = birdRadius
                )

                tubes.forEach { (x, gapY) ->
                    val tubeX = width * x
                    val tubeWidth = width * tubeWidthFraction
                    val gapYpx = height * gapY
                    val gapHeight = height * gapHeightFraction

                    drawRect(
                        color = Color(0xFF4CAF50),
                        topLeft = Offset(tubeX, 0f),
                        size = Size(tubeWidth, gapYpx)
                    )

                    drawRect(
                        color = Color(0xFF4CAF50),
                        topLeft = Offset(tubeX, gapYpx + gapHeight),
                        size = Size(tubeWidth, height - gapYpx - gapHeight)
                    )
                }

                drawIntoCanvas { canvas ->
                    val paint = Paint().asFrameworkPaint().apply {
                        isAntiAlias = true
                        color = android.graphics.Color.WHITE
                        textSize = 36f
                        textAlign = android.graphics.Paint.Align.CENTER
                    }

                    canvas.nativeCanvas.drawText("$score", width * 0.5f, height * 0.15f, paint)

                    if (!gameStarted) {
                        paint.textSize = 28f
                        canvas.nativeCanvas.drawText("Toca START", width * 0.5f, height * 0.5f, paint)
                    } else if (gameOver) {
                        paint.color = android.graphics.Color.RED
                        paint.textSize = 32f
                        canvas.nativeCanvas.drawText("GAME OVER", width * 0.5f, height * 0.4f, paint)
                        paint.color = android.graphics.Color.WHITE
                        paint.textSize = 24f
                        canvas.nativeCanvas.drawText("Score: $score", width * 0.5f, height * 0.6f, paint)
                    }
                }
            }

            Button(
                onClick = onBack,
                modifier = Modifier
                    .size(36.dp)
                    .align(Alignment.TopStart)
                    .padding(8.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Gray)
            ) {
                Text("←", fontSize = 14.sp)
            }

            Button(
                onClick = {
                    gameStarted = true
                    gameOver = false
                    birdY = 0.5f
                    birdVelocity = 0f
                    tubes = emptyList()
                    score = 0
                    lastTubeTime = System.currentTimeMillis()
                    gameSessionId++ // 🔁 Esto activa el reinicio del LaunchedEffect
                },
                modifier = Modifier
                    .size(36.dp)
                    .align(Alignment.TopCenter)
                    .padding(top = 8.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Gray)
            ) {
                Text(if (gameOver) "🔄" else "▶️", fontSize = 14.sp)
            }
        }

        Box(
            modifier = Modifier
                .weight(0.15f)
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            contentAlignment = Alignment.Center
        ) {
            Button(
                onClick = {
                    if (gameStarted && !gameOver) {
                        birdVelocity = jumpForce
                    }
                },
                modifier = Modifier.size(50.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF2196F3))
            ) {
                Text("↑", fontSize = 20.sp)
            }
        }
    }
}