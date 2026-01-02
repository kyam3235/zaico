package jp.kyamlab.zaico.di

import jp.kyamlab.zaico.database.AppDatabase
import jp.kyamlab.zaico.domain.repository.StockItemRepository
import jp.kyamlab.zaico.domain.repository.StockItemRepositoryImpl
import jp.kyamlab.zaico.presentation.stock.StockViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val appModule = module {
    viewModelOf(::StockViewModel)
    single { get<AppDatabase>().stockItemDao() }
    single<StockItemRepository> { StockItemRepositoryImpl(get()) }
}
