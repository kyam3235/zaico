package jp.kyamlab.zaico.domain.repository

import jp.kyamlab.zaico.database.StockItemDao
import jp.kyamlab.zaico.domain.model.StockItem
import kotlinx.coroutines.flow.Flow

class StockItemRepositoryImpl(
    private val stockItemDao: StockItemDao
) : StockItemRepository {
    override fun getAllAsFlow(): Flow<List<StockItem>> = stockItemDao.getAllAsFlow()

    override suspend fun getStockItem(id: Long): StockItem? = stockItemDao.getStockItem(id)

    override suspend fun getStockItemByName(name: String): StockItem? =
        stockItemDao.getStockItemByName(name)

    override suspend fun insert(item: StockItem) = stockItemDao.insert(item)

    override suspend fun update(item: StockItem) = stockItemDao.update(item)

    override suspend fun delete(item: StockItem) = stockItemDao.delete(item)
}