package br.com.fiap.foodrescue.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.fiap.foodrescue.R
import br.com.fiap.foodrescue.ui.theme.FoodRescueTheme

@Composable
fun SearchBarComponent(
    modifier: Modifier = Modifier,
    placeholder: String = stringResource(R.string.search_for_donations_near_you)
) {
    var query by remember { mutableStateOf("") }

    OutlinedTextField(
        modifier = modifier.fillMaxWidth(),
        value = query,
        onValueChange = { query = it },
        singleLine = true,
        shape = androidx.compose.foundation.shape.CircleShape,
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedBorderColor = Color.Transparent,
            focusedBorderColor = Color.Transparent,
            unfocusedContainerColor = MaterialTheme.colorScheme.primaryContainer,
            focusedContainerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        placeholder = {
            Text(
                text = placeholder,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                style = MaterialTheme.typography.bodyMedium
            )
        },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = stringResource(R.string.search_icon),
                tint = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    )
}

@Preview(showBackground = true)
@Composable
private fun SearchBarComponentPreview() {
    FoodRescueTheme {
        SearchBarComponent()
    }
}
