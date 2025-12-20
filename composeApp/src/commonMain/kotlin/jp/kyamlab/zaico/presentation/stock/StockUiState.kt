package jp.kyamlab.zaico.presentation.stock

import jp.kyamlab.zaico.domain.model.StockItem

data class StockUiState(
    val stockItems: List<StockItem> = emptyList()
)
