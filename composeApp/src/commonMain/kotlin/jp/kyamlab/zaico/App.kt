package jp.kyamlab.zaico

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import org.jetbrains.compose.ui.tooling.preview.Preview
import presentation.stock.StockScreen
import presentation.stock.StockViewModel

@Composable
@Preview
fun App() {
    MaterialTheme {
        val viewModel: StockViewModel = viewModel { StockViewModel() }
        StockScreen(viewModel = viewModel)
    }
}
