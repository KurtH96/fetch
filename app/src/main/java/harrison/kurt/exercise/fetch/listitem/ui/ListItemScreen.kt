package harrison.kurt.exercise.fetch.listitem.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import harrison.kurt.exercise.fetch.listitem.persistence.ListItemEntity
import harrison.kurt.exercise.fetch.ui.theme.FetchTheme

@Composable
fun ListItemScreen(items: List<ListItemEntity>) {
    FetchTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Column(
                modifier = Modifier.padding(innerPadding).fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(4.dp),
            ) {
                Text(text = "List Items:", fontSize = 48.sp)
                ListItemTable(items)
            }
        }
    }
}