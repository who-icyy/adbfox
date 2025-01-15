import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

@Composable
fun WelcomeScreen() {
    // Apply Material Design 3 theme
    MaterialTheme {
        // Main content
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // Welcome Text
                Text(
                    text = "Welcome to Compose Desktop!",
                    style = MaterialTheme.typography.headlineMedium
                )

                // Primary Button
                Button(
                    onClick = { /* Handle click */ },
                    modifier = Modifier.padding(horizontal = 16.dp)
                ) {
                    Text("Get Started")
                }

                // Outlined Button
                OutlinedButton(
                    onClick = { /* Handle click */ },
                    modifier = Modifier.padding(horizontal = 16.dp)
                ) {
                    Text("Learn More")
                }
            }
        }
    }
}

// Entry point for the application
fun main() = application {
    Window(onCloseRequest = ::exitApplication, title = "Welcome Screen") {
        WelcomeScreen()
    }
}
