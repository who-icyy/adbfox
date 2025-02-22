package  components
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import isAdbDeviceConnected
import kotlinx.coroutines.delay
import java.awt.FileDialog
import java.awt.Frame

@Composable
fun sideload() {
    var selectedFilePath by remember { mutableStateOf<String?>(null) }
    var isConnected by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        while (true) {
            isConnected = isAdbDeviceConnected()
            delay(5000)
        }
    }

    Button(onClick = {
        val fileDialog = FileDialog(Frame(), "Select File", FileDialog.LOAD)
        fileDialog.isVisible = true
        val selectedFile = fileDialog.file
        if (selectedFile != null) {
            selectedFilePath = "${fileDialog.directory}$selectedFile"
            // Handle the selected file path
            println("Selected file path: $selectedFilePath")
        }
    }) {
        Text("Select File")
    }

    selectedFilePath?.let {
        Row(
            modifier = Modifier
                .padding(horizontal = 200.dp)
        ) { Text(text = "Selected file: $it") }
    }

    ElevatedButton(onClick = {
        Runtime.getRuntime().exec("adb sideload $selectedFilePath")
    }, enabled = (isConnected && selectedFilePath!=null)) {
        Text("Start")
    }
}
