package com.example.ut2p1_playgames

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ut4_playjuegos2425.R
import com.example.ut4_playjuegos2425.ui.theme.colorDani
import com.example.ut4_playjuegos2425.ui.theme.inversePrimaryLight


@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun MenuNewPlayer() {
    var EstadoNombre by remember { mutableStateOf("") }
    var EstadoApellido by remember { mutableStateOf("") }
    var EstadoNick by remember { mutableStateOf("") }
    var EstadoTelf by remember { mutableStateOf("") }
    var EstadoMail by remember { mutableStateOf("") }
    var nameError by remember { mutableStateOf(false) } // Variable para el control de errores
    var pesoH = 3f
    var pesoV = 1f

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                //.padding(paddingValues)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.size(10.dp))
            Column(modifier = Modifier.padding(10.dp)) {
                Row(Modifier.fillMaxSize()) {
                    Image(
                        painter = painterResource(R.drawable.account),
                        contentDescription = "User",
                        Modifier
                            .size(60.dp)
                            .weight(1f)
                    )
                    TextField(
                        value = EstadoNombre,
                        onValueChange = {
                            EstadoNombre = it
                            nameError = false
                        },
                        Modifier.weight(2f),
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = inversePrimaryLight,
                            focusedIndicatorColor = colorDani
                        ),
                        isError = nameError,
                        label = { Text(text = ("Nombre")) },
                        shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)
                    )
                }
                Row {
                    val assistiveElementText =
                        if (nameError) "Error: Obligatorio" else "*Obligatorio" // 4
                    val assistiveElementColor = if (nameError) { // 5
                        MaterialTheme.colorScheme.error
                    } else {
                        MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f)
                    }
                    Spacer(Modifier.weight(2f))
                    Text(
                        text = assistiveElementText,
                        color = assistiveElementColor,
                        style = MaterialTheme.typography.bodySmall,
                        modifier = Modifier.weight(pesoH)
                    )
                }
                Spacer(modifier = Modifier.size(20.dp))
                Row {
                    Spacer(modifier = Modifier.weight(1f))
                    TextField(
                        value = EstadoApellido,
                        onValueChange = {
                            EstadoApellido = it
                        },
                        Modifier.weight(2f),
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = inversePrimaryLight,
                            focusedIndicatorColor = colorDani
                        ),
                        label = { Text(text = ("Apellido")) },
                        shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)
                    )
                }

                Spacer(modifier = Modifier.size(20.dp))
                Row(Modifier.fillMaxSize()) {
                    Image(
                        painter = painterResource(R.drawable.mask),
                        contentDescription = "Nickname",
                        Modifier
                            .size(60.dp)
                            .weight(1f)
                    )
                    Box(Modifier.weight(2f)){
                        MyDropDownMenu(2f)
                    }
                }
                Spacer(modifier = Modifier.size(20.dp))
                Row {
                    Spacer(
                        modifier = Modifier
                            .weight(1f)
                    )
                    Image(
                        painter = painterResource(R.drawable.android),
                        contentDescription = "Android",
                        Modifier
                            .size(100.dp)
                            .weight(2f)
                    )
                    Button(
                        onClick = { },//navController.navigate("NewPlayer") },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = colorDani,
                            contentColor = Color.Black
                        ),
                        modifier = Modifier
                            .width(200.dp)
                            .width(100.dp)
                            .weight(2f)
                            .padding(vertical = 30.dp)
                    ) {
                        Text(text = "Preferences")
                    }
                }
                Spacer(modifier = Modifier.size(20.dp))
                Row(Modifier.fillMaxSize()) {
                    Image(
                        painter = painterResource(R.drawable.phone),
                        contentDescription = "Telefono",
                        Modifier
                            .size(60.dp)
                            .weight(1f)
                    )

                    TextField(
                        value = EstadoTelf,
                        onValueChange = {
                            EstadoTelf = it
                        },
                        Modifier.weight(2f),
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = inversePrimaryLight,
                            focusedIndicatorColor = colorDani
                        ),
                        label = { Text(text = ("Teléfono")) },
                        shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)
                    )
                }
                Spacer(modifier = Modifier.size(20.dp))
                Row(Modifier.fillMaxSize()) {
                    Image(
                        painter = painterResource(R.drawable.email),
                        contentDescription = "E-mail",
                        Modifier
                            .size(60.dp)
                            .weight(1f)
                    )
                    TextField(
                        value = EstadoMail,
                        onValueChange = {
                            EstadoMail = it
                        },
                        Modifier.weight(2f),
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = inversePrimaryLight,
                            focusedIndicatorColor = colorDani
                        ),
                        label = { Text(text = ("E-mail")) },
                        shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)
                    )
                }
            }
            Spacer(Modifier.height(20.dp))
            Row() {
                Button(
                    onClick = { nameError = EstadoNombre.isBlank() },
                    shape = RoundedCornerShape(15.dp)
                ) {
                    Text(text = "Add new player")
                }

            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyDropDownMenu(peso: Float) {
    var selectedText by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }
    val usuarios =
        listOf("Blizzard", "Ryu578", "Kinton22", "Sasuke547", "Messi788")

    Column() {

            ExposedDropdownMenuBox(
                expanded = expanded,
                onExpandedChange = { expanded = !expanded },
            ) {
                TextField(
                    // The `menuAnchor` modifier must be passed to the text field for correctness.
                    modifier = Modifier
                        .menuAnchor()
                        .weight(peso),
                    readOnly = true,
                    value = selectedText,
                    onValueChange = {},
                    label = { Text("Nick") },
                    trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                    colors = ExposedDropdownMenuDefaults.textFieldColors(
                        focusedContainerColor = inversePrimaryLight,
                        unfocusedContainerColor = inversePrimaryLight,
                        //contentColorFor(inversePrimaryLight),
                        focusedIndicatorColor = colorDani,
                    ),
                    shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)
                )
                ExposedDropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false },
                ) {
                    usuarios.forEach { selectionOption ->
                        DropdownMenuItem(
                            text = { Text(selectionOption) },
                            onClick = {
                                selectedText = selectionOption
                                expanded = false
                            },
                            contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding,
                        )
                    }
                }
        }
    }
}