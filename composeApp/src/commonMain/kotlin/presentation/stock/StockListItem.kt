package presentation.stock

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import domain.model.StockItem
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import zaico.composeapp.generated.resources.Res
import zaico.composeapp.generated.resources.delete
import zaico.composeapp.generated.resources.icon_content_descriptions_delete
import zaico.composeapp.generated.resources.stock_screen_label_stock_quantity

@Composable
fun StockListItem(
    item: StockItem,
    onDeleteClick: () -> Unit
) {
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
            IconButton(onClick = onDeleteClick) {
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
fun StockListItemPreview() {
    MaterialTheme {
        StockListItem(
            item = StockItem(
                id = 1L,
                name = "Orange",
                quantity = 15,
            ),
            onDeleteClick = {},
        )
    }
}
