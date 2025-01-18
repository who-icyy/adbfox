import theme.LightColorScheme
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import components.selectFileButton
import kotlinx.coroutines.delay

@Composable
fun sideloading(navController: NavHostController) {
    var isConnected by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        while (true) {
            isConnected = isAdbDeviceConnected()
            delay(5000)
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
                    "Install A ROM",
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
                selectFileButton()
                Button(onClick = {
                    navController.navigateUp()
                }) {
                    Text("Go Back")
                }
            }
        }
    }
}
