package harrison.kurt.exercise.fetch.listitem.persistence

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/**
 * A simple definition of a Room/SQLite database to store list items. An interface of available
 * operations is queryable. This database is comprised of a single table containing a single kind of
 * entity, [ListItemEntity].
 */
@Database(entities = [ListItemEntity::class], version = 1)
abstract class ListItemDatabase : RoomDatabase() {
    /**
     * Provides an interface to perform database operations. See [ListItemDao] for more usage.
     */
    abstract fun listItemDao(): ListItemDao

    companion object {
        fun initiate(context: Context): ListItemDatabase {
           return Room.databaseBuilder(
               context,
               ListItemDatabase::class.java,
               "list-items-db"
           ).build()
        }
    }
}