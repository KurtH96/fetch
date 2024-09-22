package harrison.kurt.exercise.fetch.listitem.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun ListItemRow(id: String, name: String) {
    Row(
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = id, modifier = Modifier.width(128.dp), fontSize = 24.sp)
        Text(text = name, modifier = Modifier.fillMaxWidth(), fontSize = 24.sp)
    }
}