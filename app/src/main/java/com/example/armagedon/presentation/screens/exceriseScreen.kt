package com.example.armagedon.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DirectionsBike
import androidx.compose.material.icons.filled.DirectionsRun
import androidx.compose.material.icons.filled.DirectionsWalk
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.wear.compose.material.Button
import androidx.wear.compose.material.Icon
import androidx.wear.compose.material.Text

@Composable
fun excerciceWatch(navController:NavController){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFF000000)),
        contentAlignment = Alignment.Center
    ){
        Text(
            modifier = Modifier
                //.background(color = Color(0xFFCCFC4B))
                //.size(100.dp)
                .align(Alignment.TopCenter)
                .padding(20.dp),
            text = "1 run this week",
            color = Color(0xFFCCFC4B),
            fontSize = 12.sp
        )
        Row(modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ){
            Button( onClick = {}){
                Icon(imageVector = Icons.Default.DirectionsRun,modifier = Modifier
                    .size(38.dp), contentDescription = "")
            }
            Button( onClick = {}){
                Icon(imageVector = Icons.Default.DirectionsWalk,modifier = Modifier
                    .size(38.dp), contentDescription = "")
            }
            Button( onClick = {}){
                Icon(imageVector = Icons.Default.DirectionsBike,modifier = Modifier
                    .size(38.dp), contentDescription = "")
            }
        }
        Button(
            onClick = {},
            modifier = Modifier
                .width(60.dp)
                .height(20.dp)
                //.padding(10.dp)
                .align(Alignment.BottomCenter)){
            Text("More")
        }
    }
}
