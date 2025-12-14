package presentation.stock

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import zaico.composeapp.generated.resources.Res
import zaico.composeapp.generated.resources.add
import zaico.composeapp.generated.resources.delete
import zaico.composeapp.generated.resources.icon_content_descriptions_add
import zaico.composeapp.generated.resources.icon_content_descriptions_delete
import zaico.composeapp.generated.resources.stock_screen_label_stock_quantity
import zaico.composeapp.generated.resources.stock_screen_title

data class StockItem(val id: Long, val name: String, val quantity: Int)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StockScreen() {
    val stockItems = listOf(
        StockItem(1L, "Apple", 10),
        StockItem(2L, "Banana", 20),
        StockItem(3L, "Orange", 30)
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(
                    text = stringResource(resource = Res.string.stock_screen_title)
                ) }
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { /* TODO */ }) {
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
                items = stockItems,
                key = { item -> item.id }
            ) { item ->
                StockListItem(item)
            }
        }
    }
}

@Composable
fun StockListItem(item: StockItem) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(text = item.name, style = MaterialTheme.typography.titleLarge)
                Text(
                    text = stringResource(
                        resource = Res.string.stock_screen_label_stock_quantity,
                        item.quantity,
                    ),
                    style = MaterialTheme.typography.bodyMedium
                )
            }
            IconButton(onClick = { /* TODO */ }) {
                Icon(
                    modifier = Modifier.size(24.dp),
                    painter = painterResource(resource = Res.drawable.delete),
                    contentDescription = stringResource(
                        resource = Res.string.icon_content_descriptions_delete
                    ),
                )
            }
        }
    }
}

@Preview
@Composable
private fun StockScreenPreview() {
    StockScreen()
}
