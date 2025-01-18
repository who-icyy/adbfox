import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

val LightColorScheme = lightColorScheme(
    primary = Color(0xFFFF9800),
    onPrimary = Color.White,
    primaryContainer = Color(0xFFFFC947),
    onPrimaryContainer = Color.Black,
    secondary = Color(0xFFFFB74D),
    onSecondary = Color.Black,
    background = Color(0xFFFFFFFF),
    onBackground = Color.Black,
    surface = Color(0xFFF5F5F5),
    onSurface = Color.Black,
    error = Color(0xFFB00020),
    onError = Color.White
)

@Composable
fun mainScreen(navController: NavHostController) {
    val urlHandler = LocalUriHandler.current

    MaterialTheme(
        colorScheme = LightColorScheme
    ) {
        Box(
            modifier = androidx.compose.ui.Modifier.fillMaxSize(),
            contentAlignment = androidx.compose.ui.Alignment.Center
        ) {
            Column(
                horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // Welcome Message
                Text(
                    "Welcome to adbFOX!",
                    style = MaterialTheme.typography.headlineMedium
                )
                // Buttons
                Button(onClick = {
                    navController.navigate("install_rom")
                }) {
                    Text("Install A ROM")
                }

                ElevatedButton(onClick = {
                    urlHandler.openUri("https://www.github.com/who-icyy/adbfox")
                }) {
                    Text("Learn More")
                }
            }
        }
    }
}



@Composable
fun appNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "main") {
        composable("main") {
            mainScreen(navController = navController)
        }
        composable("install_rom") {
            home(navController = navController)
        }
    }
}

@Composable
fun app() {
    val navController = rememberNavController()
    appNavHost(navController = navController)

}

fun main() = application {
    Window(onCloseRequest = ::exitApplication, title = "adbFOX") {
        app()
    }
}
