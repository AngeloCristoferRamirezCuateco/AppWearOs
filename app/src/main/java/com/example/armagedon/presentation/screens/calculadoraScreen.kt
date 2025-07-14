package com.example.armagedon.presentation.screens

import androidx.benchmark.perfetto.Row
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.wear.compose.foundation.lazy.ScalingLazyColumn
import kotlin.math.pow
import kotlin.math.sqrt

@Composable
fun Calculadora(navController: NavController) {
    var caja by remember { mutableStateOf("0") }
    var resultado by remember { mutableDoubleStateOf(0.0) }
    var operador by remember { mutableStateOf("0") }
    var dato1 by remember { mutableDoubleStateOf(0.0) }

    fun PresionarBoton(button: String) {
        when (button) {
            in "0".."9", "." -> {
                caja = if (caja == "0") button else caja + button
            }
            in listOf("/", "*", "-", "+") -> {
                operador = button
                dato1 = caja.toDouble()
                caja = "0"
            }
            "=" -> {
                resultado = when (operador) {
                    "/" -> dato1 / caja.toDouble()
                    "*" -> dato1 * caja.toDouble()
                    "-" -> dato1 - caja.toDouble()
                    "+" -> dato1 + caja.toDouble()
                    else -> 0.0
                }
                caja = resultado.toString()
            }
            "C" -> {
                resultado = 0.0
                caja = "0"
            }
            "+/-" -> {
                resultado = -1.0 * caja.toDouble()
                caja = resultado.toString()
            }
            "X²" -> {
                resultado = caja.toDouble().pow(2)
                caja = resultado.toString()
            }
            "√" -> {
                resultado = sqrt(caja.toDouble())
                caja = resultado.toString()
            }
        }
    }

    ScalingLazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            Text(
                text = "Calculadora",
                color = Color.White,
                style = MaterialTheme.typography.titleLarge
            )
        }

        item {
            Text(
                text = caja,
                color = Color.White,
                style = MaterialTheme.typography.displayLarge,
                modifier = Modifier.padding(vertical = 8.dp)
            )
        }

        val filas = listOf(
            listOf("7", "8", "9", "/", "C"),
            listOf("4", "5", "6", "*", "+/-"),
            listOf("1", "2", "3", "-", "X²"),
            listOf("0", ".", "=", "+", "√")
        )

        filas.forEach { fila ->
            item {
                Renglones(*fila.toTypedArray()) { PresionarBoton(it) }
            }
        }
    }
}

@Composable
fun Renglones(vararg buttons: String, onClick: (String) -> Unit) {
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
    ) {
        buttons.forEach { button ->
            Button(
                onClick = { onClick(button) },
                modifier = Modifier
                    .padding(2.dp)
                    .size(28.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFB39DDB), // Lila claro
                    contentColor = Color.White         // Texto blanco explícito
                ),
                contentPadding = PaddingValues(0.dp)
            ) {
                Text(
                    text = button,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

