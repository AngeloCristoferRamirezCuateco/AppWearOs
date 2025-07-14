package com.example.armagedon.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.runtime.Composable
import java.time.LocalTime
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.VolumeUp
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Pause
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.SkipNext
import androidx.compose.material.icons.filled.SkipPrevious
import androidx.compose.material.icons.filled.VolumeUp
import androidx.compose.material3.IconButton
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.Text
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import java.time.format.DateTimeFormatter
import androidx.wear.compose.material.Icon
//navController: NavController,

@Composable
fun MusicPlayerScreen(
    navController: NavController,
    title: String = "Chef Table Radio",
    artist: String = "Eli Kulp",
    isPlaying: Boolean = true,
    time: String = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm"))
){
    val korado = Color(0xFFB000B5)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.radialGradient(
                    colors = listOf(Color.Black, korado),
                    radius = 600f
                )
            )
            .padding(8.dp)){
                // Hora arriba
                Text(
                    text = time,
                    color = Color.White,
                    fontSize = 14.sp,
                    modifier = Modifier.align(Alignment.TopCenter)
                )

                // Título y artista
                Column(
                    modifier = Modifier
                        .align(Alignment.TopCenter)
                        .padding(top = 28.dp),
                    horizontalAlignment = Alignment.CenterHorizontally)
                {
                    Text(text = title, color = Color.White, fontSize = 16.sp, fontWeight = FontWeight.Bold)
                    Text(text = artist, color = Color.LightGray, fontSize = 14.sp)
                }

                // Botones principales - CENTRADOS VERTICALMENTE
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(bottom = 2.dp), // Ajusta este valor para mover los botones hacia arriba/abajo
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally)
                {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.CenterVertically)
                    {
                        IconButton(onClick = { /* anterior */ }) {
                            Icon(
                                imageVector = Icons.Default.SkipPrevious,
                                contentDescription = "Anterior",
                                tint = Color.White,
                                modifier = Modifier.size(32.dp)
                            )
                        }

                        IconButton(
                            onClick = { /* play/pause */ },
                            modifier = Modifier
                                .size(50.dp)
                                .background(Color.White.copy(alpha = 0.1f), CircleShape)
                                .border(2.dp, korado, CircleShape))
                        {
                            Icon(
                                imageVector = if (isPlaying) Icons.Default.Pause else Icons.Default.PlayArrow,
                                contentDescription = "Play/Pause",
                                tint = Color.White,
                                modifier = Modifier.size(32.dp)
                            )
                        }

                        IconButton(onClick = { /* siguiente */ }) {
                            Icon(
                                imageVector = Icons.Default.SkipNext,
                                contentDescription = "Siguiente",
                                tint = Color.White,
                                modifier = Modifier.size(32.dp)
                            )
                        }
                    }
                }

                // Botones inferiores - AHORA MÁS ABAJO
                Row(
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .fillMaxWidth()
                        .padding(bottom = 20.dp, start = 32.dp, end = 32.dp), // Aumenté el padding inferior
                    horizontalArrangement = Arrangement.SpaceBetween)
                {
                    IconButton(onClick = { /* like */ }) {
                        Icon(
                            imageVector = Icons.Default.FavoriteBorder,
                            contentDescription = "Me gusta",
                            tint = Color.White,
                            modifier = Modifier.size(24.dp)
                        )
                    }
                    IconButton(onClick = { /* volumen */ }) {
                        Icon(
                            imageVector = Icons.Default.VolumeUp,
                            contentDescription = "Volumen",
                            tint = Color.White,
                            modifier = Modifier.size(24.dp)
                        )
                    }
                }

                // Indicador de páginas - AHORA MÁS ABAJO
                Row(
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(bottom = 24.dp), // Aumenté el padding inferior
                    horizontalArrangement = Arrangement.Center)
                {
                    repeat(2) { index ->
                        Box(
                            modifier = Modifier
                                .size(8.dp)
                                .clip(CircleShape)
                                .background(
                                    if (index == 0) Color.White else Color.Gray
                                )
                        )
                        if (index == 0) Spacer(modifier = Modifier.width(8.dp))
                    }
                }
            }
}
