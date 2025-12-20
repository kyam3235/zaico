package jp.kyamlab.zaico

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import jp.kyamlab.zaico.presentation.stock.StockScreen
import jp.kyamlab.zaico.presentation.stock.StockViewModel
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI

@OptIn(KoinExperimentalAPI::class)
@Composable
@Preview
fun App() {
    MaterialTheme {
        val viewModel: StockViewModel = koinViewModel()
        StockScreen(viewModel = viewModel)
    }
}
