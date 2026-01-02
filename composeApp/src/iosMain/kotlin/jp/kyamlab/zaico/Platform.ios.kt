package jp.kyamlab.zaico

import jp.kyamlab.zaico.database.AppDatabase
import jp.kyamlab.zaico.database.getRoomDatabase
import org.koin.core.module.Module
import org.koin.dsl.module

actual fun getPlatformModule(): Module = module {
    single<AppDatabase> {
        val builder = getDatabaseBuilder()
        getRoomDatabase(builder = builder)
    }
}