package com.example.ut4_playjuegos2425

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ut2p1_playgames.MenuNewPlayer
import com.example.ut2p1_playgames.Preferences
import com.example.ut4_playjuegos2425.ui.theme.UT4_PlayJuegos2425Theme
import com.example.ut4_playjuegos2425.ui.theme.courgetteRegularFamily
import java.util.prefs.Preferences

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UT4_PlayJuegos2425Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Surface(
                        modifier = Modifier.fillMaxSize().padding(innerPadding),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        val navController = rememberNavController()
                        NavHost(navController = navController, startDestination = "PlayJuegos") {
                            composable("NewPlayer") { MenuNewPlayer() }
                            composable("PlayJuegos") { MenuPlayGames(navController) }
                            composable("Preferences") { Preferences() }
                            composable("Play") { Juegos() }
                            composable("Usuarios") { UsersView() }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun MenuPlayGames(navController: NavHostController) {
    val configuration = LocalConfiguration.current
    when (configuration.orientation) {
        Configuration.ORIENTATION_PORTRAIT -> {
            MenuVertical(navController)
        }
        else -> {
            MenuHorizontal(navController)
        }
    }

}

@Composable
fun MenuVertical(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(
                painter = painterResource(id = R.drawable.rasengan),
                contentDescription = "Rasengan", Modifier.size(150.dp)
            )
            Text(
                "Play Games", style = TextStyle(
                    fontSize = 50.sp,
                    fontFamily = courgetteRegularFamily,
                    fontWeight = FontWeight.Normal,
                    color = Color.Black
                )
            )
            Spacer(modifier = Modifier.size(20.dp))
            Button(
                onClick = { navController.navigate("Play") },
                modifier = Modifier.width(200.dp)
            ) {
                Text(text = "Play")
            }
            //Spacer(modifier = Modifier.size(20.dp))
            Button(
                onClick = {navController.navigate("NewPlayer") },
                modifier = Modifier.width(200.dp)
            ) {
                Text(text = "New Player")
            }
            Button(
                onClick = {  navController.navigate("Preferences") },
                modifier = Modifier.width(200.dp)
            ) {
                Text(text = "Preferences")
            }
            //Spacer(modifier = Modifier.size(20.dp))
            //Button(onClick = { navController.navigate("Preferences") }, modifier = Modifier.width(200.dp)) {
            Button(
                onClick = { navController.navigate("Usuarios") },
                modifier = Modifier.width(200.dp)
            ) {
                Text(text = "Users")

            }
            Button(
                onClick = { },//navController.navigate("About") },
                modifier = Modifier.width(200.dp)
            ) {
                Text(text = "About")

            }
        }
    }
}

@Composable
fun MenuHorizontal(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {

            Row(
                /* verticalArrangement = Arrangement.Center,
                 horizontalAlignment = Alignment.CenterHorizontally*/
            ) {
                Column(verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally) {
                    Box(
                        modifier = Modifier
                            .background(Color.Cyan)
                            .size(150.dp)
                    ) {

                    }
                    Text(
                        "Play Games", style = TextStyle(
                            fontSize = 50.sp,
                            //fontFamily = courgetteRegularFamily,
                            fontWeight = FontWeight.Normal,
                            color = Color.Black
                        )
                    )
                }

            }
            Row {
                Button(
                    onClick = { navController.navigate("Play") },
                    modifier = Modifier.width(200.dp)
                ) {
                    Text(text = "Play")
                }
                Spacer(modifier = Modifier.size(20.dp))
                Button(
                    onClick = { navController.navigate("NewPlayer") },
                    modifier = Modifier.width(200.dp)
                ) {
                    Text(text = "Preferences")
                }
            }
            Row {
                Button(
                    onClick = { },//navController.navigate("Preferences") },
                    modifier = Modifier.width(200.dp)
                ) {
                    Text(text = "New Player")
                }
                Spacer(modifier = Modifier.size(20.dp))
                Button(
                    onClick = { navController.navigate("Usuarios") },
                    modifier = Modifier.width(200.dp)
                ) {
                    Text(text = "Users")

                }
            }
            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center) {
                Button(
                    onClick = { },//navController.navigate("About") },
                    modifier = Modifier.width(200.dp)
                ) {
                    Text(text = "About")
                }
            }

        }
    }
}

