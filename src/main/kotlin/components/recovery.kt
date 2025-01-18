package components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import java.awt.FileDialog
import java.awt.Frame


@Composable
fun recovery() {
    var selectedFilePath by remember { mutableStateOf<String?>(null) }

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
        Runtime.getRuntime().exec("fastboot flash recovery $selectedFilePath")
    }, enabled = (selectedFilePath!=null)) {
        Text("Flash Recovery")
    }
    ElevatedButton(onClick = {
        Runtime.getRuntime().exec("fastboot boot $selectedFilePath")
    }, enabled = (selectedFilePath!=null)) {
        Text("Boot Recovery")
    }
    ElevatedButton(onClick = {
        Runtime.getRuntime().exec("fastboot flash boot $selectedFilePath")
    }, enabled = (selectedFilePath!=null)) {
        Text("Flash Boot Recovery (MTK)")
    }
}
