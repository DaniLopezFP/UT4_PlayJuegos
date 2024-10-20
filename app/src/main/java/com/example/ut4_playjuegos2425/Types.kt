package com.example.ut4_playjuegos2425

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ut4_playjuegos2425.ui.theme.colorDani
import com.example.ut4_playjuegos2425.ui.theme.inversePrimaryLight

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun Juegos() {
    Surface {
        Column {
            Text(text = "Plataformas:", fontSize = 24.sp, fontWeight = FontWeight.Bold)
            ChipGroupCompose()
            Text(text = "Géneros:", fontSize = 24.sp, fontWeight = FontWeight.Bold)
            MyTypesList()
        }

    }
}


@Composable
fun MyTypesList() {
    val tipos = listOf(
        "Aventura",
        "Acción",
        "RPG",
        "Deportes",
        "Shooter",
        "Estrategia",
        "Lucha",
        "Simulación"
    )
    Column() {
        LazyColumn(modifier = Modifier.padding(10.dp)) {
            items(tipos) {
                /*Surface(modifier = Modifier.fillMaxWidth()) {
                Text(text = "$it")
            }*/
                CreaCard(nombre = "$it")
            }
        }
    }
}

@Composable
fun CreaCard(nombre: String) {
    var imagen: Int = 0
    var descripcion: String = ""
    var context = LocalContext.current

    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 16.dp
        ),
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .clickable {
                Toast
                    .makeText(context, nombre, Toast.LENGTH_LONG)
                    .show()
            }
        //.height(60.dp),
        , shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(containerColor = colorDani)
    ) {
        Row(Modifier.fillMaxSize(), horizontalArrangement = Arrangement.SpaceAround) {
            Text(
                text = nombre,
                modifier = Modifier
                    .padding(16.dp)
                    .weight(1f),
                textAlign = TextAlign.Center,
            )
            when (nombre) {
                "Aventura" -> {
                    imagen = R.drawable.zelda
                    descripcion = "Zelda"
                }

                "Acción" -> {
                    imagen = R.drawable.spider
                    descripcion = "Marvel`s Spider-man 2"
                }

                "RPG" -> {
                    imagen = R.drawable.baldurs
                    descripcion = "Baldur's Gate 3"
                }

                "Deportes" -> {
                    imagen = R.drawable.fc24
                    descripcion = "FC 24"
                }

                "Shooter" -> {
                    imagen = R.drawable.cod
                    descripcion = "Call of Duty"
                }

                "Estrategia" -> {
                    imagen = R.drawable.civilization
                    descripcion = "Civilization"
                }

                "Lucha" -> {
                    imagen = R.drawable.foz
                    descripcion = "Dragon Ball Figther of Z"
                }

                "Simulación" -> {
                    imagen = R.drawable.flight
                    descripcion = "Microsoft Flight Simulator"
                }
            }
            Image(
                painter = painterResource(id = imagen),
                contentDescription = descripcion,
                Modifier
                    .fillMaxSize()
                    .weight(1f),
                contentScale = ContentScale.Crop
            )

        }
    }
    Spacer(modifier = Modifier.size(5.dp))
}

@OptIn(ExperimentalMaterial3Api::class)
//@Preview(showBackground = true)
@Composable
fun FilterChipExample(opcion: String) {
    var selected by remember { mutableStateOf(false) }
    var colores: Color = colorDani

    FilterChip(
        onClick = {
            selected = !selected

        },
        label = {
            Text(opcion)
        },
        colors = FilterChipDefaults.filterChipColors(
            containerColor = inversePrimaryLight,
            labelColor = Color.White,
            selectedContainerColor = colores
        ),
        selected = selected,
        leadingIcon = if (selected) {
            {
                Icon(
                    imageVector = Icons.Filled.Done,
                    contentDescription = "Done icon",
                    modifier = Modifier.size(FilterChipDefaults.IconSize)
                )
            }
        } else {
            null
        },
    )
}

@Preview(showBackground = true)
@Composable
fun ChipGroupCompose() {
    val nombre: String

    val plataformas: List<String> = listOf(
        "PS5",
        "XBox X/S",
        "Switch",
        "PC",
        "Steam",
        "GeForce now"
    )

    var selectec by remember { mutableStateOf("") }

    Row(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        LazyRow(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            for (opcion in plataformas) {
                item {
                    FilterChipExample(opcion)
                    Spacer(Modifier.size(5.dp))
                }
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar(nombre: String) {
    TopAppBar(title = { Text(text = nombre) })
}
