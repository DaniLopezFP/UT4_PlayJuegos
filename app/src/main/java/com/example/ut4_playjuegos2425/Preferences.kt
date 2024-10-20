package com.example.ut2p1_playgames

import android.widget.Toast
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ut4_playjuegos2425.R
import com.example.ut4_playjuegos2425.ui.theme.colorDani
import com.example.ut4_playjuegos2425.ui.theme.courgetteRegularFamily
import com.example.ut4_playjuegos2425.ui.theme.primaryLight

var puntuaJuego: String = ""

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun Preferences() {
    //val scaffoldState = rememberScaffoldState()
    var estadoRadio by rememberSaveable { mutableStateOf("No has pulsado ninguna opción") }
    var puntuacion by remember { mutableStateOf(50f) }
    var corutineScope = rememberCoroutineScope()


    Scaffold(
        floatingActionButton = { MyFAB(estadoRadio) },
        floatingActionButtonPosition = FabPosition.End
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        )//{, contentAlignment = Alignment.Center) {
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
            Spacer(modifier = Modifier.height(10.dp))
            Spacer(modifier = Modifier.width(10.dp))
            Row(Modifier.padding(start = 10.dp)) {
                Text(
                    "Elige una opción:", style = TextStyle(
                        fontSize = 20.sp,
                        fontFamily = courgetteRegularFamily,
                        fontWeight = FontWeight.Normal,
                        color = primaryLight
                    )
                )
            }

            Spacer(modifier = Modifier.size(20.dp))
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Column(
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.Start
                ) {
                    //var estadoRadio by rememberSaveable { mutableStateOf("opción 1") }
                    MyRadioButton(estadoRadio) { estadoRadio = it }
                }
            }

        }
    }
}


@Composable
fun MyRadioButton(name: String, onItemSelected: (String) -> Unit) {
    Column(
        Modifier
            .fillMaxSize()
            .height(20.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Row() {
            Column {
                RadioButton(
                    selected = name == "Angry Birds",
                    onClick = { onItemSelected("Angry Birds") }
                )
            }
            Column(Modifier.padding(top = 10.dp, end = 5.dp)) {
                Image(
                    painter = painterResource(R.drawable.games_angrybirds),
                    contentDescription = "Android",
                    Modifier
                        .size(30.dp)
                )
            }
            Column {
                Text(text = "Angry Birds", Modifier.padding(top = 12.dp))
            }
        }
        Row() {
            Column {
                RadioButton(
                    selected = name == "Dragon Fly",
                    onClick = { onItemSelected("Dragon Fly") })
            }
            Column(Modifier.padding(top = 10.dp, end = 5.dp)) {
                Image(
                    painter = painterResource(R.drawable.games_dragonfly),
                    contentDescription = "Android",
                    Modifier
                        .size(30.dp)
                )
            }
            Column {
                Text(text = "Dragon Fly", Modifier.padding(top = 12.dp))
            }
        }
        Row() {
            Column {
                RadioButton(
                    selected = name == "Hill Climbing Racing",
                    onClick = { onItemSelected("Hill Climbing Racing") })
            }
            Column(Modifier.padding(top = 10.dp, end = 5.dp)) {
                Image(
                    painter = painterResource(R.drawable.games_hillclimbingracing),
                    contentDescription = "Android",
                    Modifier
                        .size(30.dp)
                )
            }
            Column {
                Text(text = "Hill Climbing Racing", Modifier.padding(top = 12.dp))
            }
        }
        Row() {
            Column {
                RadioButton(
                    selected = name == "Pocket Soccer",
                    onClick = { onItemSelected("Pocket Soccer") })
            }
            Column(Modifier.padding(top = 10.dp, end = 5.dp)) {
                Image(
                    painter = painterResource(R.drawable.games_pocketsoccer),
                    contentDescription = "Android",
                    Modifier
                        .size(30.dp)
                )
            }
            Column {
                Text(text = "Pocket Soccer", Modifier.padding(top = 12.dp))
            }
        }
        Row() {
            Column {
                RadioButton(
                    selected = name == "Radiant Defense",
                    onClick = { onItemSelected("Radiant Defense") })
            }
            Column(Modifier.padding(top = 10.dp, end = 5.dp)) {
                Image(
                    painter = painterResource(R.drawable.games_radiantdefense),
                    contentDescription = "Android",
                    Modifier
                        .size(30.dp)
                )
            }
            Column { Text(text = "Radiant Defense", Modifier.padding(top = 12.dp)) }

        }
        SimpleDiscreteSlider()


        Row(
            Modifier
                .fillMaxSize()
                .padding(10.dp)
        ) {
            TextoColor(name)
        }
        Row(
            Modifier
                .fillMaxSize()
                .padding(10.dp)
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text("Juego completado")
                MySwitch()
            }
            Column(modifier = Modifier.weight(1f)) {
                Text("Guardar comentario")
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    MySwitch()
                }

            }

        }
    }
}

@Composable
fun SimpleDiscreteSlider() {
    val range = 0f..10f
    val steps = 8
    var selection by remember { mutableStateOf(5f) }
    var completeValule by remember { mutableStateOf("5") }
    Column {
        Slider(
            value = selection,
            valueRange = range,
            steps = steps,
            onValueChange = { selection = it },
            onValueChangeFinished = { completeValule = selection.toInt().toString() }
        )
        puntuaJuego = completeValule
    }

}

@Composable
fun MyFAB(seleccion: String) {
    var context = LocalContext.current

    FloatingActionButton(
        onClick = {
            if (seleccion != "No has pulsado ninguna opción") {
                Toast.makeText(
                    context,
                    "Has seleccionado " + seleccion + " con una puntuación de " + puntuaJuego,
                    Toast.LENGTH_LONG
                )
                    .show()
            } else {
                Toast.makeText(context, seleccion, Toast.LENGTH_LONG)
                    .show()
            }
        },
        containerColor = colorDani
    ) {
        Icon(imageVector = Icons.Filled.Add, contentDescription = "Add")
    }
}

@Composable
fun TextoColor(name: String) {
    var estadoTextField by remember { mutableStateOf(TextFieldValue("")) }
    val valoracion = ""

    val rainbowColors: List<Color> =
        listOf(Color.Magenta, Color(0xFFE03F1A), Color(0xFFE1CB15), Color.Green, Color.Cyan)

    val brush = remember {
        Brush.linearGradient(
            colors = rainbowColors
        )
    }
    Column {
        Row(Modifier.padding(10.dp)) {
            if (name == "No has pulsado ninguna opción") {
                Text(
                    "Reseña personal: juego no seleccionado", style = TextStyle(
                        fontSize = 20.sp,
                        fontFamily = courgetteRegularFamily,
                        fontWeight = FontWeight.Normal,
                        color = primaryLight
                    )
                )
            } else {
                Text(
                    "Reseña personal de $name", style = TextStyle(
                        fontSize = 20.sp,
                        fontFamily = courgetteRegularFamily,
                        fontWeight = FontWeight.Normal,
                        color = primaryLight
                    )
                )
            }
        }
        Row {
            TextField(
                value = estadoTextField,
                onValueChange = { estadoTextField = it },
                textStyle = TextStyle(brush = brush),
                label = { name },
            )
        }
    }
}

@Composable
fun MySwitch() {
    var state by rememberSaveable { mutableStateOf(true) }

    Switch(
        checked = state,
        onCheckedChange = {
            state = it
        },
        thumbContent = if (state) {
            {
                Icon(
                    imageVector = Icons.Filled.Check,
                    contentDescription = null,
                    modifier = Modifier.size(SwitchDefaults.IconSize),
                )
            }
        } else {
            null
        }
    )
}