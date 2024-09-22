package harrison.kurt.exercise.fetch.listitem.ui

import androidx.lifecycle.ViewModel
import harrison.kurt.exercise.fetch.listitem.persistence.ListItemEntity
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ListItemViewModel: ViewModel() {
    private val _ListItems = MutableStateFlow(listOf<ListItemEntity>())
    val listItems =_ListItems.asStateFlow()

    fun updateItems(items: List<ListItemEntity>) {
        _ListItems.update { items }
    }
}