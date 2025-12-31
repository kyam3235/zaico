package jp.kyamlab.zaico.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import jp.kyamlab.zaico.domain.model.StockItem
import kotlinx.coroutines.flow.Flow

@Dao
interface StockItemDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item: StockItem)

    @Update
    suspend fun update(item: StockItem)

    @Delete
    suspend fun delete(item: StockItem)

    @Query("SELECT * FROM stock_items")
    fun getAllAsFlow(): Flow<List<StockItem>>

    @Query("SELECT * FROM stock_items WHERE id = :id")
    suspend fun getStockItem(id: Long): StockItem?

    @Query("SELECT * FROM stock_items WHERE name = :name")
    suspend fun getStockItemByName(name: String): StockItem?
}
