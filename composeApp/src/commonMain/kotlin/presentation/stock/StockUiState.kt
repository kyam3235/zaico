package presentation.stock

import domain.model.StockItem

data class StockUiState(
    val stockItems: List<StockItem> = emptyList()
)
