@file:OptIn(ExperimentalSerializationApi::class)

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
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.decodeFromStream
import java.io.BufferedInputStream
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL



class MainActivity : ComponentActivity() {
    lateinit var db: ListItemDatabase
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
        Thread {
            dbTest()
            networkTest()
        }.start()
    }

    /**
     * Test showing basic network request
     */
    private fun networkTest() {
        val url = URL("https://fetch-hiring.s3.amazonaws.com/hiring.json")
        val urlConnection = url.openConnection() as HttpURLConnection
        try {
            val input: InputStream = BufferedInputStream(urlConnection.inputStream)
            val list = Json.decodeFromStream<List<ListItemEntity>>(input)
            db.listItemDao().insertAll(*list.toTypedArray())
            println("DONE")
        } finally {
            urlConnection.disconnect()
        }
    }

    /**
     * Test showing basic setup
     */
    private fun dbTest() {
        db = Room.databaseBuilder(
            applicationContext,
            ListItemDatabase::class.java,
            "list-items-db"
        ).build()
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