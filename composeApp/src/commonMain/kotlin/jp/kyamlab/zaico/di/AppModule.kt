package jp.kyamlab.zaico.di

import jp.kyamlab.zaico.presentation.stock.StockViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val appModule = module {
    viewModelOf(::StockViewModel)
}
