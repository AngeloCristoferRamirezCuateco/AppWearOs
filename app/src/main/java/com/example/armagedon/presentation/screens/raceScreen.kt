package com.example.armagedon.presentation.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.wear.compose.material.Icon
import androidx.compose.material.icons.filled.DirectionsRun
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.Color
import androidx.wear.compose.material.Text

@Composable
fun raceWatch(navController: NavController){
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ){

        Icon(
            imageVector = Icons.Default.DirectionsRun,
            contentDescription = "Apps",
            modifier = Modifier
                .padding(50.dp)
                .align(Alignment.TopCenter),
            tint = Color(0xFFCCFC4B)
        )

        Text(
            text = "7:21 / mi",
            modifier = Modifier
                .align(Alignment.Center)
                .padding(30.dp)
                //.size(20.dp)
        )

        Text(
            text = "Running",
            modifier = Modifier
                .padding(60.dp)
                .align(Alignment.BottomCenter),
                //.size(10.dp),
            color = Color(0xFFCCFC4B)
        )
    }
}
