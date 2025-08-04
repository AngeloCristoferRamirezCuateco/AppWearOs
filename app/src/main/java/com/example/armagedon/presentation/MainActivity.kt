package com.example.armagedon.presentation

import android.os.Bundle
import android.text.format.DateFormat
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.wear.compose.material.Button
import androidx.wear.compose.material.Icon
import androidx.wear.compose.material.Text
import androidx.wear.compose.material.TimeText
import androidx.wear.compose.material.TimeTextDefaults
import androidx.wear.tooling.preview.devices.WearDevices
import com.example.armagedon.R
import com.example.armagedon.presentation.oswaapp.EditReminderScreen
import com.example.armagedon.presentation.oswaapp.ExerciseReminderViewModel
import com.example.armagedon.presentation.oswaapp.Recordatorios
import java.util.Locale
import com.example.armagedon.presentation.screens.excerciceWatch
import com.example.armagedon.presentation.screens.yogaWatch
import com.example.armagedon.presentation.screens.stepsWatch
import com.example.armagedon.presentation.screens.raceWatch
import com.example.armagedon.presentation.screens.activitiesWatch
import com.example.armagedon.presentation.screens.pelotonWatch
import com.example.armagedon.presentation.screens.AnalogWatchFaceExample
import com.example.armagedon.presentation.screens.SpeedDistanceScreen
import com.example.armagedon.presentation.screens.MusicPlayerScreen
import com.example.armagedon.presentation.screens.ChatScreen
import com.example.armagedon.presentation.screens.Calculadora
import com.example.armagedon.presentation.screens.EyeRestScreen
import com.example.armagedon.presentation.screens.TrackInfo
import com.example.armagedon.presentation.screens.repMusica
import com.example.armagedon.presentation.screens.PlaylistScreen
import com.example.armagedon.presentation.screens.FlappyBirdScreen

object canciones{
    val canciones = listOf(
        TrackInfo("1", R.raw.dust_in_the_wind, "BadLand", "Boom Kitty", R.drawable.peloton),
        TrackInfo("2", R.raw.a_horse_with_no_name, "At The Speed of Light", "Dimrain47", R.drawable.peloton),
        // Más canciones aquí
    )
}
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setTheme(android.R.style.Theme_DeviceDefault)

        setContent {

            WearApp("Android",canciones.canciones);

        }
    }
}
@Composable
fun mainWatch(navController:NavController){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFF154360)),
        contentAlignment = Alignment.Center
    ) {
        Canvas(modifier = Modifier.fillMaxSize()){
            val centerX = size.width / 2
            val centerY = size.height / 2
            val radius = (size.minDimension / 2) -3.dp.toPx()

            drawCircle(
                color = Color.Black,
                center = Offset(centerX, centerY),
                radius = radius,
                style = Stroke(width = 6.dp.toPx()),
                alpha = 0.8f,
                blendMode = BlendMode.Overlay
            )
        }
        TimeText(
            modifier = Modifier
                .padding(12.dp),
            timeSource = TimeTextDefaults.timeSource(
                DateFormat.getBestDateTimePattern(Locale.getDefault(), "yyyy-MM-dd hh:mm")
            )
        )

        Button(
            onClick = { navController.navigate("navigationBar") },
            modifier = Modifier
                .width(100.dp)
                .height(50.dp)
        ){
            Row(verticalAlignment = Alignment.CenterVertically){
                Icon(
                    imageVector = Icons.Default.Apps,
                    //imageVector = Icons.Default.Apps, // Icono de Material Icons
                    contentDescription = "Apps",
                    modifier = Modifier
                        .size(18.dp))
                    Spacer(Modifier.width(8.dp))
                    Text("Apps")
            }
            //Text( "Ir a Apps")
        }
        Text(
            text = "@Derechos resevados",
            fontSize = 8.sp,

            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(20.dp)

        )
    }
}

@Composable
fun BarraNavegacion( navController:NavController){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFF154360)),
        contentAlignment = Alignment.Center
    ){
        Canvas(modifier = Modifier.fillMaxSize()){
            val centerX = size.width / 2
            val centerY = size.height / 2
            val radius = (size.minDimension / 2) -3.dp.toPx()

            drawCircle(
                color = Color.Black,
                center = Offset(centerX, centerY),
                radius = radius,
                style = Stroke(width = 6.dp.toPx()),
                alpha = 0.8f,
                blendMode = BlendMode.Overlay
            )
        }
        LazyColumn (
                modifier = Modifier
                    .height(120.dp)
                    .width(250.dp)
                    .padding(horizontal = 40.dp)
            ){
                items(10) { index ->
                    Column(
                        modifier = Modifier.padding(5.dp)
                    ){
                        Button(
                            onClick = { navController.navigate("music")  },
                            modifier = Modifier
                                .width(250.dp)
                                .height(30.dp)
                        ){
                            Row(verticalAlignment = Alignment.CenterVertically){
                                Icon(
                                    imageVector = Icons.Default.LibraryMusic,
                                    //imageVector = Icons.Default.Apps, // Icono de Material Icons
                                    contentDescription = "Apps",
                                    modifier = Modifier
                                        .size(18.dp))
                                Spacer(Modifier.width(8.dp))
                                Text("Musica")
                            }
                            //Text( "Musica")
                        }

                        Spacer(Modifier.height(6.dp)) //<-- Esto es un espaciador

                        Button(
                            onClick = { navController.navigate("chat")  },
                            modifier = Modifier
                                .width(150.dp)
                                .height(30.dp)
                        ){
                            Row(verticalAlignment = Alignment.CenterVertically){
                                Icon(
                                    imageVector = Icons.Default.Chat,
                                    //imageVector = Icons.Default.Apps, // Icono de Material Icons
                                    contentDescription = "Apps",
                                    modifier = Modifier
                                        .size(18.dp))
                                Spacer(Modifier.width(8.dp))
                                Text("Chat")
                            }
                            //Text( "Chat")
                        }

                        Spacer(Modifier.height(6.dp))

                        Button(
                            onClick = { navController.navigate("steps")  },
                            modifier = Modifier
                                .width(150.dp)
                                .height(30.dp)
                        ){
                            Row(verticalAlignment = Alignment.CenterVertically){
                                Icon(
                                    imageVector = Icons.Default.DirectionsRun,
                                    //imageVector = Icons.Default.Apps, // Icono de Material Icons
                                    contentDescription = "Apps",
                                    modifier = Modifier
                                        .size(18.dp))
                                Spacer(Modifier.width(8.dp))
                                Text("Pasos")
                            }
                            //Text( "Pasos")
                        }

                        Spacer(Modifier.height(6.dp))

                        Button(
                            onClick = { navController.navigate("exercise") },
                            modifier = Modifier
                                .width(150.dp)
                                .height(30.dp)
                        ){
                            Row(verticalAlignment = Alignment.CenterVertically){
                                Icon(
                                    imageVector = Icons.Default.SettingsAccessibility,
                                    //imageVector = Icons.Default.Apps, // Icono de Material Icons
                                    contentDescription = "Apps",
                                    modifier = Modifier
                                        .size(18.dp))
                                Spacer(Modifier.width(8.dp))
                                Text("Ejercicio")
                            }
                            //Text( "Ejercicio")
                        }

                        Spacer(Modifier.height(6.dp))

                        Button(
                            onClick = { navController.navigate("yoga") },
                            modifier = Modifier
                                .width(150.dp)
                                .height(30.dp)
                        ){
                            Row(verticalAlignment = Alignment.CenterVertically){
                                Icon(
                                    imageVector = Icons.Default.SelfImprovement,
                                    //imageVector = Icons.Default.Apps, // Icono de Material Icons
                                    contentDescription = "Apps",
                                    modifier = Modifier
                                        .size(18.dp))
                                Spacer(Modifier.width(8.dp))
                                Text("Yoga")
                            }
                            //Text( "Yoga")
                        }

                        Spacer(Modifier.height(6.dp))

                        Button(
                            onClick = { navController.navigate("time")  },
                            modifier = Modifier
                                .width(150.dp)
                                .height(30.dp)
                        ){
                            Row(verticalAlignment = Alignment.CenterVertically){
                                Icon(
                                    imageVector = Icons.Default.WatchLater,
                                    //imageVector = Icons.Default.Apps, // Icono de Material Icons
                                    contentDescription = "Apps",
                                    modifier = Modifier
                                        .size(18.dp))
                                Spacer(Modifier.width(8.dp))
                                Text(
//                                    modifier = Modifier
//                                        .size(2.dp),
                                    text = "Cronometro",
                                    fontSize = 10.sp
                                )
                            }
                            //Text( "Cronometro")
                        }

                        Spacer(Modifier.height(6.dp))

                        Button(
                            onClick = { navController.navigate("race") },
                            modifier = Modifier
                                .width(150.dp)
                                .height(30.dp)
                        ){
                            Row(verticalAlignment = Alignment.CenterVertically){
                                Icon(
                                    imageVector = Icons.Default.DirectionsRun,
                                    //imageVector = Icons.Default.Apps, // Icono de Material Icons
                                    contentDescription = "Apps",
                                    modifier = Modifier
                                        .size(18.dp))
                                Spacer(Modifier.width(8.dp))
                                Text(
                                    //modifier = Modifier
                                      //  .size(2.dp),
                                    text = "Carrera"
                                )
                            }
                            //Text( "Cronometro")
                        }

                        Spacer(Modifier.height(6.dp))

                        Button(
                            onClick = { navController.navigate("activities") },
                            modifier = Modifier
                                .width(150.dp)
                                .height(30.dp)
                        ){
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(
                                    imageVector = Icons.Default.List,
                                    //imageVector = Icons.Default.Apps, // Icono de Material Icons
                                    contentDescription = "Actividades",
                                    modifier = Modifier
                                        .size(18.dp)
                                )
                                Spacer(Modifier.width(8.dp))
                                Text(
                                    //modifier = Modifier
                                    //.size(2.dp),
                                    text = "Actividades",
                                    fontSize = 10.sp
                                )
                            }
                        }

                        Spacer(Modifier.height(6.dp))

                        Button(
                            onClick = { navController.navigate("peloton") },
                            modifier = Modifier
                                .width(150.dp)
                                .height(30.dp)
                        ){
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(
                                    painter = painterResource(R.drawable.peloton), 
                                    contentDescription = "Peloton",
                                    modifier = Modifier
                                        .size(18.dp)
                                )
                                Spacer(Modifier.width(8.dp))
                                Text(
                                    //modifier = Modifier
                                    //.size(2.dp),
                                    text = "Peloton",
                                    fontSize = 10.sp
                                )
                            }
                        }

                        Spacer(Modifier.height(6.dp))

                        Button(
                            onClick = { navController.navigate("calculadora") },
                            modifier = Modifier
                                .width(150.dp)
                                .height(30.dp)
                        ){
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(
                                    imageVector = Icons.Default.Calculate,
                                    //painter = painterResource(R.drawable.peloton),
                                    contentDescription = "Calculadora",
                                    modifier = Modifier
                                        .size(18.dp)
                                )
                                Spacer(Modifier.width(8.dp))
                                Text(
                                    //modifier = Modifier
                                    //.size(2.dp),
                                    text = "Calculadora",
                                    fontSize = 10.sp
                                )
                            }
                        }

                        Spacer(Modifier.height(6.dp))

                        Button(
                            onClick = { navController.navigate("rest") },
                            modifier = Modifier
                                .width(150.dp)
                                .height(30.dp)
                        ){
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(
                                    imageVector = Icons.Default.Bedtime,
                                    //painter = painterResource(R.drawable.peloton),
                                    contentDescription = "Descanzo",
                                    modifier = Modifier
                                        .size(18.dp)
                                )
                                Spacer(Modifier.width(8.dp))
                                Text(
                                    //modifier = Modifier
                                    //.size(2.dp),
                                    text = "Descanzo",
                                    fontSize = 10.sp
                                )
                            }
                        }

                        Spacer(Modifier.height(6.dp))

                        Button(
                            onClick = { navController.navigate("Musica") },
                            modifier = Modifier
                                .width(150.dp)
                                .height(30.dp)
                        ){
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(
                                    imageVector = Icons.Default.LibraryMusic,
                                    //painter = painterResource(R.drawable.peloton),
                                    contentDescription = "Musica",
                                    modifier = Modifier
                                        .size(18.dp)
                                )
                                Spacer(Modifier.width(8.dp))
                                Text(
                                    //modifier = Modifier
                                    //.size(2.dp),
                                    text = "Musica",
                                    fontSize = 10.sp
                                )
                            }
                        }

                        Spacer(Modifier.height(6.dp))

                        Button(
                            onClick = { navController.navigate("oswaApp") },
                            modifier = Modifier
                                .width(150.dp)
                                .height(30.dp)
                        ){
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(
                                    imageVector = Icons.Default.EditCalendar,
                                    //painter = painterResource(R.drawable.peloton),
                                    contentDescription = "oswaApp",
                                    modifier = Modifier
                                        .size(18.dp)
                                )
                                Spacer(Modifier.width(8.dp))
                                Text(
                                    //modifier = Modifier
                                    //.size(2.dp),
                                    text = "Recordatorio",
                                    fontSize = 10.sp
                                )
                            }
                        }

                        Spacer(Modifier.height(6.dp))

                        Button(
                            onClick = { navController.navigate("game") },
                            modifier = Modifier
                                .width(150.dp)
                                .height(30.dp)
                        ){
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(
                                    imageVector = Icons.Default.EditCalendar,
                                    //painter = painterResource(R.drawable.peloton),
                                    contentDescription = "game",
                                    modifier = Modifier
                                        .size(18.dp)
                                )
                                Spacer(Modifier.width(8.dp))
                                Text(
                                    //modifier = Modifier
                                    //.size(2.dp),
                                    text = "FlapyBird",
                                    fontSize = 10.sp
                                )
                            }
                        }

                    }

                }
            }
    }
}

@Composable
fun WearApp(greetingName: String, songList: List<TrackInfo>) {
    val navController = rememberNavController()
    var currentIndex by remember { mutableStateOf(0) }
    val viewModel: ExerciseReminderViewModel = viewModel()


    NavHost(
        navController = navController,
        startDestination = "main"
    ) {
        composable("main") { mainWatch(navController) }
        composable("navigationBar") { BarraNavegacion(navController) }
        //FaceWatchs
        composable("exercise") { excerciceWatch(navController) }
        composable("yoga") { yogaWatch(navController) }
        composable("steps") { stepsWatch(navController) }
        composable("race") { raceWatch(navController) }
        composable("activities") { activitiesWatch(navController) }
        composable("peloton") { pelotonWatch(navController) }
        composable("time") { AnalogWatchFaceExample(navController) }
        composable("speed") { SpeedDistanceScreen(navController) }
        composable("music") { MusicPlayerScreen(navController) }
        composable("chat") { ChatScreen(navController) }
        composable("calculadora") {
            MaterialTheme(
                colorScheme = darkColorScheme() // Para Material 3
                // o colors = darkColors()      // Para Material 2
            ) {
                Calculadora(navController)
            }
        }
        composable("rest") { EyeRestScreen(navController) }
        composable("Musica") {
            repMusica(
                initialSongIndex = currentIndex,
                songList = songList,
                onNavigateToPlaylist = { index, _ ->
                    currentIndex = index
                    navController.navigate("playlist")
                },
                onBack = { navController.popBackStack() }
            )
        }
        composable("playlist") {
            PlaylistScreen(
                songList = songList,
                currentPlayingIndex = currentIndex,
                onSongSelected = { selectedIndex ->
                    currentIndex = selectedIndex
                    navController.popBackStack()
                },
                onBack = { navController.popBackStack() }
            )
        }
        composable("oswaApp") { Recordatorios(navController, viewModel) }
        composable("editReminder/{day}") { backStackEntry ->
            val day = backStackEntry.arguments?.getString("day") ?: ""
            EditReminderScreen(navController, day, viewModel)
        }
        composable("game") { FlappyBirdScreen { navController } }
    }
}

@Preview(device = WearDevices.SMALL_ROUND, showSystemUi = true)
@Composable
fun DefaultPreview() {
    WearApp("Preview Android",canciones.canciones)
}