package jp.kyamlab.zaico.di

import jp.kyamlab.zaico.getPlatform
import org.koin.dsl.module

val platformModule = module {
    single { getPlatform() }
}
