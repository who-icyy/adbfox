import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun home(navController: NavHostController) {
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
                Text(
                    "Install A ROM",
                    style = MaterialTheme.typography.headlineMedium
                )
                Text("Here you can install a ROM by following the steps.")

                Button(onClick = {
                    navController.navigateUp()
                }) {
                    Text("Go Back")
                }
            }
        }
    }
}