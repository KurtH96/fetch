package harrison.kurt.exercise.fetch

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.room.Room
import harrison.kurt.exercise.fetch.listitem.persistence.ListItemDatabase
import harrison.kurt.exercise.fetch.listitem.persistence.ListItemEntity
import harrison.kurt.exercise.fetch.ui.theme.FetchTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FetchTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
        dbTest()
    }

    /**
     * Test showing basic setup
     */
    private fun dbTest() {
        Thread {
            val db = Room.databaseBuilder(
                applicationContext,
                ListItemDatabase::class.java,
                "list-items-db"
            ).build()
            val dao = db.listItemDao()
            val entity = ListItemEntity(0,0, "foo")
            dao.insertAll(entity)
        }.start()
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FetchTheme {
        Greeting("Android")
    }
}