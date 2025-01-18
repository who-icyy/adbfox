package  components
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import java.awt.FileDialog
import java.awt.Frame

@Composable
fun selectFileButton() {
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
        Text(text = "Selected file: $it")
    }
}
