package jp.kyamlab.zaico

import androidx.compose.ui.window.ComposeUIViewController
import jp.kyamlab.zaico.di.initKoin

@Suppress("FunctionName", "unused")
fun MainViewController() = ComposeUIViewController(
    configure = {
        initKoin()
    }
) {
    App()
}
