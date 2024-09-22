package harrison.kurt.exercise.fetch.listitem.persistence

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

/**
 * A basic data access object providing an interface to perform needed database operations.
 */
@Dao
interface ListItemDao {
    /**
     * Returns all stored items.
     */
    @Query("SELECT * FROM list_item")
    fun getAll(): List<ListItemEntity>

    /**
     * Returns all stored items as they are updated. The "where" clause of this select-statement
     * conveniently filters out both null and empty values. Consumers of this flow will only receive
     * list items that have a valid name.
     */
    @Query("SELECT * FROM list_item WHERE name != \"\"")
    fun getUpdates(): Flow<List<ListItemEntity>>

    /**
     * Inserts all provided list items into the local database.
     * Existing entries are replaced with newer instances.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg items: ListItemEntity)

    /**
     * Removes a list item from the database.
     */
    @Delete
    fun delete(item: ListItemEntity)
}