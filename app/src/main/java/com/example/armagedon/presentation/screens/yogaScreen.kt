package com.example.armagedon.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.wear.ambient.AmbientLifecycleObserver
import androidx.wear.compose.material.Button
import androidx.wear.compose.material.Text
import androidx.wear.tooling.preview.devices.WearDevices

@Composable
fun yogaWatch(navController: NavController){
    Box(
        modifier = Modifier
            .background(Color.Black)
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Text(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(30.dp),
            text = "Power Yoga",
            color = Color(0xFFCCFC4B),
            )
        Button(
            onClick = {},
            modifier = Modifier
                .width(120.dp)
                .height(50.dp)
        ){
            Text("Start")
        }
        Text(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(30.dp),
            text = "Last session 45m"
        )
    }
}