package jp.kyamlab.zaico.domain.repository

import jp.kyamlab.zaico.domain.model.StockItem
import kotlinx.coroutines.flow.Flow

interface StockItemRepository {
    fun getAllAsFlow(): Flow<List<StockItem>>
    suspend fun getStockItem(id: Long): StockItem?
    suspend fun getStockItemByName(name: String): StockItem?
    suspend fun insert(item: StockItem)
    suspend fun update(item: StockItem)
    suspend fun delete(item: StockItem)
}
