package components

import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import isAdbDeviceConnected
import kotlinx.coroutines.delay
import java.awt.FileDialog
import java.awt.Frame

@Composable
fun recovery() {
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
        Text(text = "Selected file: $it")
    }

    ElevatedButton(onClick = {

    }, enabled = (isConnected && selectedFilePath!=null)) {
        Text("Flash Recovery")
    }
    ElevatedButton(onClick = {

    }, enabled = (isConnected && selectedFilePath!=null)) {
        Text("Boot Recovery")
    }
    ElevatedButton(onClick = {

    }, enabled = (isConnected && selectedFilePath!=null)) {
        Text("Flash Boot Recovery (MTK)")
    }
}
