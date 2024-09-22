package harrison.kurt.exercise.fetch.listitem.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import harrison.kurt.exercise.fetch.listitem.persistence.ListItemEntity

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ListItemTable(listItems: List<ListItemEntity>) {
    val groups = listItems.groupBy { it.listId }.toSortedMap(compareBy { it })

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.75f)
            .padding(16.dp, 0.dp)
            .border(BorderStroke(1.dp, Color.Gray))
            .padding(8.dp, 2.dp),
        verticalArrangement = Arrangement.spacedBy(2.dp),
    ) {
        groups.forEach { (list, listGroup) ->
            stickyHeader {
                Surface(Modifier.fillParentMaxWidth()) {
                    Text(text = "List $list", fontSize = 32.sp)
                }
            }
            listGroup.forEach { item ->
                item{ ListItemRow(item.id.toString(), item.name.toString()) }
            }
        }
    }
}