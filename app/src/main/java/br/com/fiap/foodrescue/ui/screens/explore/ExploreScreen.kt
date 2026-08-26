package br.com.fiap.foodrescue.ui.screens.explore

import android.content.res.Configuration
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.foodrescue.R
import br.com.fiap.foodrescue.ui.components.MyBottomAppBar
import br.com.fiap.foodrescue.ui.components.SearchBarComponent
import br.com.fiap.foodrescue.ui.components.TopAppBarComponent
import br.com.fiap.foodrescue.ui.theme.FoodRescueTheme

@Composable
fun ExploreScreen(
    modifier: Modifier = Modifier,
    onNavigateToHome: () -> Unit = {},
    onNavigateToRetiradas: () -> Unit = {},
    onNavigateToPerfil: () -> Unit = {}
) {
    Scaffold(
        modifier = modifier
            .fillMaxSize()
            .statusBarsPadding(),
        containerColor = MaterialTheme.colorScheme.background,
        topBar = { TopAppBarComponent(title = stringResource(R.string.explore)) },
        bottomBar = { MyBottomAppBar(currentRoute = stringResource(R.string.explore)) }
    ) { paddingValues ->
        ExploreContentScreen(
            modifier = Modifier.padding(paddingValues)
        )
    }
}

@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Composable
private fun ExplorarScreenPreview() {
    FoodRescueTheme {
        ExploreScreen()
    }
}


@Composable
fun ExploreContentScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background) // Fundo da tela Branco
            .padding(horizontal = 16.dp)
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        SearchBarComponent()
        HorizontalDivider(
            modifier = Modifier.padding(top = 12.dp),
            thickness = 1.dp,
            color = MaterialTheme.colorScheme.onSurface
        )
        Spacer(modifier = Modifier.height(12.dp))
        FilterChipsSection()
        Spacer(modifier = Modifier.height(16.dp))
        DonationListSection(modifier = Modifier.weight(1f))
    }
}


@Composable
private fun FilterChipsSection() {
    val filters = listOf(
        stringResource(R.string.all),
        stringResource(R.string.produce),
        stringResource(R.string.baking),
        stringResource(R.string.dairy)
    )
    var selectedFilter by remember { mutableStateOf("All") }
    LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        items(filters) { filter ->
            val isSelected = filter == selectedFilter
            Surface(
                shape = RoundedCornerShape(16.dp),
                color = if (isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSecondary,
                shadowElevation = if (isSelected) 4.dp else 0.dp,
                border = if (!isSelected) BorderStroke(1.dp, MaterialTheme.colorScheme.onSurface) else null,
                modifier = Modifier.padding(vertical = 4.dp),
                onClick = { selectedFilter = filter }
            ) {
                Text(
                    text = filter,
                    color = if (isSelected) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onSurface,
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                    fontSize = 14.sp
                )
            }
        }
    }
}

@Composable
private fun DonationListSection(modifier: Modifier = Modifier) {
    val donations = listOf(
        DonationItem(
            stringResource(R.string.mixed_fruits),
            "Sacola da Vila",
            stringResource(R.string._5_units_available),
            "0.8km",
            imageRes = R.drawable.fruits
        ),
        DonationItem(
            stringResource(R.string.artisan_breads),
            "Padaria Pão & Arte",
            stringResource(R.string._10_units_available),
            "1.2km",
            imageRes = R.drawable.bread
        ),
        DonationItem(
            stringResource(R.string.ready_meals),
            "Restaurante Sabor da Terra",
            stringResource(R.string._6_units_available),
            "1.5km",
            imageRes = R.drawable.marmita
        ),
        DonationItem(
            stringResource(R.string.fresh_vegetables),
            "Horta Comunitária",
            stringResource(R.string._2_units_available),
            "2.0km",
            imageRes = R.drawable.legumes
        )
    )

    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(12.dp),
        contentPadding = androidx.compose.foundation.layout.PaddingValues(bottom = 16.dp)
    ) {
        items(donations) { item ->
            DonationCard(item)
        }
    }
}

@Composable
private fun DonationCard(item: DonationItem) {
    Surface(
        shape = RoundedCornerShape(16.dp),
        color = MaterialTheme.colorScheme.background,
        shadowElevation = 4.dp,
        modifier = Modifier.fillMaxWidth(),
        border = BorderStroke(width = 1.dp, color = MaterialTheme.colorScheme.outline)
    ) {
        androidx.compose.foundation.layout.Row(
            modifier = Modifier
                .padding(12.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(72.dp)
                    .clip(RoundedCornerShape(12.dp))
            ) {
                if (item.imageRes != null) {
                    Image(
                        painter = painterResource(id = item.imageRes),
                        contentDescription = item.title,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.matchParentSize()
                    )
                } else {
                    Box(
                        modifier = Modifier
                            .matchParentSize()
                            .background(MaterialTheme.colorScheme.background)
                    )
                }
            }

            Spacer(modifier = Modifier.width(12.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = item.title,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onBackground,
                    style = MaterialTheme.typography.titleSmall
                )
                Text(
                    text = item.supplier,
                    color = MaterialTheme.colorScheme.primary,
                    style = MaterialTheme.typography.bodySmall
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = item.quantity,
                    color = MaterialTheme.colorScheme.secondary,
                    style = MaterialTheme.typography.bodySmall
                )
            }

            Column(horizontalAlignment = Alignment.End) {
                Text(
                    text = item.distance,
                    color = MaterialTheme.colorScheme.onSurface,
                    style = MaterialTheme.typography.bodySmall
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = stringResource(R.string.rescue),
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
}

data class DonationItem(
    val title: String,
    val supplier: String,
    val quantity: String,
    val distance: String,
    val imageRes: Int? = null
)
