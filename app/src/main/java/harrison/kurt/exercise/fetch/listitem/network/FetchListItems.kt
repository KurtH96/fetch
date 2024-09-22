@file:OptIn(ExperimentalSerializationApi::class)

package harrison.kurt.exercise.fetch.listitem.network

import harrison.kurt.exercise.fetch.listitem.persistence.ListItemDatabase
import harrison.kurt.exercise.fetch.listitem.persistence.ListItemEntity
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.decodeFromStream
import java.io.BufferedInputStream
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL

/**
 * Creates a HTTP request to fetch list items from a remote source. Items are then inserted into a
 * local database to be consumed be this application. Raw JSON data is parsed into usable entities.
 */
class FetchListItems {
    operator fun invoke(database: ListItemDatabase) {
        val url = URL("https://fetch-hiring.s3.amazonaws.com/hiring.json")
        val urlConnection = url.openConnection() as HttpURLConnection
        try {
            val input: InputStream = BufferedInputStream(urlConnection.inputStream)
            val list = Json.decodeFromStream<List<ListItemEntity>>(input)
            database.listItemDao().insertAll(*list.toTypedArray())
        } finally {
            urlConnection.disconnect()
        }
    }
}