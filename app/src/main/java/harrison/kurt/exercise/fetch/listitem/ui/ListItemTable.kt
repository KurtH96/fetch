package harrison.kurt.exercise.fetch.listitem.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ListItemTable() {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.75f)
            .padding(16.dp, 0.dp)
            .border(BorderStroke(1.dp, Color.Gray))
            .padding(8.dp, 2.dp),
        verticalArrangement = Arrangement.spacedBy(2.dp),
    ) {
        stickyHeader { ListItemRow("ID", "List", "Name") }
        item { ListItemRow("0", "0",  "foo") }
        item { ListItemRow("0", "0",  "foo") }
        item { ListItemRow("0", "0",  "foo") }
        item { ListItemRow("0", "0",  "foo") }
        item { ListItemRow("0", "0",  "foo") }
        item { ListItemRow("0", "0",  "foo") }
        item { ListItemRow("0", "0",  "foo") }
        item { ListItemRow("0", "0",  "foo") }
        item { ListItemRow("0", "0",  "foo") }
        item { ListItemRow("0", "0",  "foo") }
    }
}