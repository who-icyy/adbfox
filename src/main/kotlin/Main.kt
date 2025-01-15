import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.foundation.layout.*
import androidx.compose.ui.unit.dp


// Custom Green Color Scheme for Dark Mode
private val DarkGreenColorScheme = darkColorScheme(
    primary = Color(0xFF4CAF50), // Green (Primary color)
    onPrimary = Color.White,    // Text color on primary
    primaryContainer = Color(0xFF388E3C), // Darker green for containers
    onPrimaryContainer = Color.White,
    secondary = Color(0xFF81C784), // Light green (Secondary color)
    onSecondary = Color.Black,
    background = Color(0xFF121212), // Dark background
    onBackground = Color.White,
    surface = Color(0xFF1E1E1E), // Dark surface
    onSurface = Color.White,
    error = Color(0xFFCF6679), // Error color (default Material color)
    onError = Color.Black
)

@Composable
fun App() {
    // Apply the custom dark green theme
    MaterialTheme(
        colorScheme = DarkGreenColorScheme
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
                Button(onClick = { println("Install Button Clicked") }) {
                    Text("Install A ROM")
                }

                OutlinedButton(onClick = { println("Learn More clicked") }) {
                    Text("Learn More")
                }
            }
        }
    }
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication, title = "adbFOX") {
        App()
    }
}
