package jp.kyamlab.zaico.di

import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module
import presentation.stock.StockViewModel

val appModule = module {
    viewModelOf(::StockViewModel)
}
