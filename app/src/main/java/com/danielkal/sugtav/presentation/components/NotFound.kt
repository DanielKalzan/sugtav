package com.danielkal.sugtav.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CreditCardOff
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.danielkal.sugtav.R
import com.danielkal.sugtav.presentation.theme.SugtavTheme
import com.danielkal.sugtav.presentation.util.formatIsraeliVehicleNumber

@Composable
fun NotFound(modifier: Modifier = Modifier, carNumber: String) {

    Card(
        modifier = modifier
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp, start = 8.dp, end = 8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Row {
                Icon(
                    modifier = Modifier
                        .size(40.dp)
                        .padding(top = 8.dp),
                    imageVector = Icons.Default.CreditCardOff,
                    contentDescription = null
                )

                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp, end = 40.dp, bottom = 8.dp),
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.titleLarge,
                    text = stringResource(R.string.not_found_car),
                )
            }

            Box(
                modifier = Modifier
                    .background(
                        MaterialTheme.colorScheme.surface,
                        shape = MaterialTheme.shapes.small
                    )
            ) {
                Text(
                    modifier = Modifier
                        .padding(16.dp),
                    style = MaterialTheme.typography.titleLarge,
                    textAlign = TextAlign.Center,
                    text = formatIsraeliVehicleNumber(carNumber)
                )
            }


        }
    }

}


@Preview
@Composable
private fun NotFoundPreview() {

    SugtavTheme {
        NotFound(
            modifier = Modifier,
            carNumber = "52788403"
        )
    }

}