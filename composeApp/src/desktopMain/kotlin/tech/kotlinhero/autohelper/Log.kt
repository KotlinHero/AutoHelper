package tech.kotlinhero.autohelper

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Log(
    logs: List<String>,
    modifier: Modifier = Modifier,
    maxLines: Int = 100
) {
    val displayedLogs = if (logs.size > maxLines) {
        logs.takeLast(maxLines)
    } else {
        logs
    }

    LazyColumn(
        modifier = modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.onPrimary)
            .padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(2.dp)
    ) {
        if (displayedLogs.isEmpty()) {
            item {
                Text(
                    text = "No logs yet",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.6f),
                    fontSize = 14.sp
                )
            }
        } else {
            items(displayedLogs) { log ->
                LogLine(log)
            }
        }
    }
}

@Composable
private fun LogLine(
    log: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = log,
        fontFamily = FontFamily.Monospace,
        fontSize = 12.sp,
        color = MaterialTheme.colorScheme.onSurface,
        modifier = modifier.fillMaxWidth()
    )
}