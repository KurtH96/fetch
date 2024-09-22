package harrison.kurt.exercise.fetch

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.lifecycleScope
import harrison.kurt.exercise.fetch.listitem.network.FetchListItems
import harrison.kurt.exercise.fetch.listitem.persistence.ListItemDatabase
import harrison.kurt.exercise.fetch.listitem.ui.ListItemScreen
import harrison.kurt.exercise.fetch.listitem.ui.ListItemViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    private lateinit var db: ListItemDatabase
    private val viewModel: ListItemViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycleScope.launch(Dispatchers.Default) {
            db = ListItemDatabase.initiate(applicationContext)
            db.listItemDao().getUpdates().collectLatest(viewModel::updateItems)
        }

        setContent {
            val items by viewModel.listItems.collectAsStateWithLifecycle()
            ListItemScreen(items)
        }
    }

    override fun onStart() {
        super.onStart()
        lifecycleScope.launch(Dispatchers.IO) {
            FetchListItems()(db)
        }
    }

    override fun onDestroy() {
        db.close()
        super.onDestroy()
    }
}