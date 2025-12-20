package jp.kyamlab.zaico

import android.app.Application
import jp.kyamlab.zaico.di.initKoin
import org.koin.android.ext.koin.androidContext

class ZaicoApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidContext(this@ZaicoApplication)
        }
    }
}
