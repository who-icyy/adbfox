import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import components.indicator
import components.selectFileButton

@Composable
fun home(navController: NavHostController, isConnected: Boolean) {
    MaterialTheme {
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
                indicator(isConnected = isConnected)
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
