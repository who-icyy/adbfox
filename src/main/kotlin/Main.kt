import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import fragments.flashRecovery
import fragments.sideloading
import theme.LightColorScheme
import java.io.BufferedReader
import java.io.InputStreamReader

@Suppress("DEPRECATION")
fun isAdbDeviceConnected(): Boolean {
    return try {
        val process = Runtime.getRuntime().exec("adb devices")
        val reader = BufferedReader(InputStreamReader(process.inputStream))
        process.waitFor()
        val output = reader.readLines()
        val deviceLines = output.drop(1)
        deviceLines.any { it.contains("device") && !it.contains("offline") && !it.contains("unauthorized") }
    } catch (e: Exception) {
        e.printStackTrace()
        false
    }
}@Suppress("DEPRECATION")
fun isFastbootDeviceConnected(): Boolean {
    return try {
        val process = Runtime.getRuntime().exec("fastboot devices")
        val reader = BufferedReader(InputStreamReader(process.inputStream))
        process.waitFor()
        val output = reader.readLines()
        val deviceLines = output.drop(1)
        deviceLines.any { it.contains("device") && !it.contains("offline") && !it.contains("unauthorized") }
    } catch (e: Exception) {
        e.printStackTrace()
        false
    }
}

fun executeIt(cmd: String){

}

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
                Button(onClick = {
                    navController.navigate("install_recovery")
                }) {
                    Text("Flash Recovery")
                }

                Button(onClick = {
                    navController.navigate("install_rom")
                }) {
                    Text("Sideload ROM")
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
            sideloading(navController = navController)
        }
        composable("install_recovery") {
            flashRecovery(navController = navController)
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
