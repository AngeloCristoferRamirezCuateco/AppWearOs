package com.example.armagedon.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.runtime.Composable
import java.time.LocalTime
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.Text
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import java.time.format.DateTimeFormatter
import com.example.armagedon.R
import androidx.compose.ui.text.TextStyle

@Composable
fun ChatScreen(
    navController: NavController,
    userName: String = "Jessica Roberts",
    message: String = "Hey! Hope it's going well!",
    time: String = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm"))
) {
    val korado = Color(0xFFB000B5) // Morado

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF2C2C2C)) // Fondo oscuro
            .padding(16.dp)
    ) {
        // Hora
        Text(
            text = time,
            color = Color.White,
            fontSize = 14.sp,
            modifier = Modifier.align(Alignment.TopCenter)
        )

        // Imagen de perfil
        Box(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 20.dp)
                .size(30.dp)
                .clip(CircleShape)
                .border(2.dp, korado, CircleShape)
        ) {
            Image(
                painter = painterResource(id = R.drawable.peloton), // Cambia con tu imagen
                contentDescription = "Profile Image",
                modifier = Modifier.fillMaxSize()
            )
        }

        // Nombre y fecha
        Column(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 50.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = userName, color = Color.White, fontSize = 18.sp, fontWeight = FontWeight.Bold)
            Text(text = "Tuesday · Now", color = Color.Gray, fontSize = 14.sp)
        }

        // Mensaje de texto
        Box(
            modifier = Modifier
                .align(Alignment.Center)
                .padding(top = 90.dp)
                .widthIn(max = 110.dp) // Ajusta el ancho máximo, puedes reducirlo si lo ves muy grande
                .background(Color(0xFF2196F3), shape = RoundedCornerShape(12.dp)) // Azul estilo Material Blue 500
                .padding(horizontal = 16.dp, vertical = 12.dp)
        ) {
            Text(
                text = message,
                color = Color.White,
                style = TextStyle(fontSize = 12.sp)
            )
        }

    }
}
