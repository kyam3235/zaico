package jp.kyamlab.zaico.presentation.stock

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import jp.kyamlab.zaico.domain.model.StockItem
import jp.kyamlab.zaico.domain.repository.StockItemRepository
import kotlinx.coroutines.launch
import kotlin.random.Random

class StockViewModel(
    private val stockItemRepository: StockItemRepository
) : ViewModel() {
    var uiState by mutableStateOf(value = StockUiState())

    init {
        viewModelScope.launch {
            stockItemRepository.getAllAsFlow().collect {
                uiState = uiState.copy(stockItems = it)
            }
        }
    }

    fun deleteItem(itemToDelete: StockItem) {
        viewModelScope.launch {
            stockItemRepository.delete(itemToDelete)
        }
    }

    fun addItem() {
        viewModelScope.launch {
            val rand = Random(0)
            stockItemRepository.insert(
                item = StockItem(
                    name = "New Item",
                    id = rand.nextLong(),
                    quantity = 100
                )
            )
        }
    }
}
