package harrison.kurt.exercise.fetch.listitem.persistence

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Definition of list item entities. List items are stored in a table named "list_item".
 */
@Entity(tableName = "list_item")
data class ListItemEntity(
    @PrimaryKey val id: Int,
    // Column renamed to adhere to both SQLite and Kotlin naming conventions.
    @ColumnInfo(name = "list_id") val listId: Int,
    val name: String?,
)