package jp.kyamlab.zaico

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import org.jetbrains.compose.ui.tooling.preview.Preview
import presentation.stock.StockScreen

@Composable
@Preview
fun App() {
    MaterialTheme {
        StockScreen()
    }
}