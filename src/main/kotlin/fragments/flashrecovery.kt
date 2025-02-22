package fragments

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import components.recovery
import isFastbootDeviceConnected
import kotlinx.coroutines.delay
import theme.LightColorScheme

@Composable
fun flashRecovery(navController: NavHostController) {
    var isConnected by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        while (true) {
            isConnected = isFastbootDeviceConnected()
            delay(5000) // Check every 10 seconds instead of 5
        }
    }

    MaterialTheme(colorScheme = LightColorScheme) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Text(
                    "Flashing Recovery",
                    style = MaterialTheme.typography.headlineMedium
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(12.dp)
                            .background(
                                color = if (isConnected) Color.Green else Color.Red,
                                shape = MaterialTheme.shapes.small
                            )
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = if (isConnected) "Connected" else "Disconnected")
                }
                recovery()
                Button(onClick = {
                    navController.navigateUp()
                }) {
                    Text("Go Back")
                }
            }
        }
    }
}
