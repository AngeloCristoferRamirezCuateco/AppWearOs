package com.example.armagedon.presentation.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.wear.compose.material.Text
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.armagedon.R
import androidx.wear.compose.material.Icon

@Composable
fun pelotonWatch(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.align(Alignment.TopCenter),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            // Imagen de Peloton
            Image(
                painter = painterResource(id = R.drawable.peloton),
                contentDescription = "Peloton Logo",
                modifier = Modifier
                    .size(24.dp)
                    .clip(CircleShape)
            )

            // Texto principal
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "Peloton App:",
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Start a workout on your",
                    color = Color.White,
                    fontSize = 14.sp
                )
                Text(
                    text = "mobile device.",
                    color = Color.White,
                    fontSize = 14.sp
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            // Estado del equipo
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "Peloton equipment:",
                    color = Color.White,
                    fontSize = 14.sp
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.Check,
                        contentDescription = "Connected",
                        tint = Color.White,
                        modifier = Modifier.size(18.dp)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = "Connected",
                        color = Color.White,
                        fontSize = 14.sp
                    )
                }
            }
        }
    }
}
