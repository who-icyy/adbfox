package components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.Dp

@Composable
fun StatusIndicator(
    isConnected: Boolean,
    modifier: Modifier = Modifier,
    dotSize: Dp = 12.dp,
    connectedColor: Color = Color.Green,
    disconnectedColor: Color = Color.Red
) {
    val statusText = if (isConnected) "Connected" else "Disconnected"
    val dotColor = if (isConnected) connectedColor else disconnectedColor

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        Box(
            modifier = Modifier
                .size(dotSize)
                .background(color = dotColor, shape = MaterialTheme.shapes.small)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = statusText)
    }
}
