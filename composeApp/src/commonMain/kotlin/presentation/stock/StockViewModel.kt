package presentation.stock

import androidx.lifecycle.ViewModel
import domain.model.StockItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class StockViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(
        StockUiState(
            stockItems = listOf(
                StockItem(1L, "Apple", 10),
                StockItem(2L, "Banana", 20),
                StockItem(3L, "Orange", 30)
            )
        )
    )
    val uiState: StateFlow<StockUiState> = _uiState.asStateFlow()

    fun deleteItem(itemToDelete: StockItem) {
        _uiState.update { currentState ->
            val updatedItems = currentState.stockItems.filter { it.id != itemToDelete.id }
            currentState.copy(stockItems = updatedItems)
        }
    }

    fun addItem() {
        // TODO: Implement logic to add a new item
    }
}
