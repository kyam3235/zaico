package jp.kyamlab.zaico.presentation.stock

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import zaico.composeapp.generated.resources.Res
import zaico.composeapp.generated.resources.add
import zaico.composeapp.generated.resources.icon_content_descriptions_add
import zaico.composeapp.generated.resources.stock_screen_title

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StockScreen(
    viewModel: StockViewModel,
) {
    val uiState by viewModel.uiState.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(resource = Res.string.stock_screen_title)
                    )
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { viewModel.addItem() }) {
                Icon(
                    modifier = Modifier.size(24.dp),
                    painter = painterResource(resource = Res.drawable.add),
                    contentDescription = stringResource(
                        resource = Res.string.icon_content_descriptions_add
                    ),
                )
            }
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier.fillMaxSize().padding(paddingValues),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(
                items = uiState.stockItems,
                key = { item -> item.id }
            ) { item ->
                StockListItem(
                    item = item,
                    onDeleteClick = { viewModel.deleteItem(item) }
                )
            }
        }
    }
}

@Preview
@Composable
private fun StockScreenPreview() {
    MaterialTheme {
        StockScreen(
            viewModel = StockViewModel()
        )
    }
}
