package com.example.sugtav.presentation.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
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
import com.example.sugtav.R
import com.example.sugtav.domain.model.VehicleRecord

@Composable
fun InfoCard(modifier: Modifier = Modifier) {
    Card(
        modifier = modifier,
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Row {
                Icon(modifier = Modifier.size(40.dp).padding(top = 8.dp), imageVector = Icons.Default.Info, contentDescription = null)
                Text(
                    modifier = Modifier.fillMaxWidth()
                        .padding(8.dp),
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.titleLarge,
                    text = "שים לב !!!",
                )
            }


            Text(
                modifier = Modifier.fillMaxWidth()
                    .padding(8.dp),
                textAlign = TextAlign.Center,
                text = stringResource(R.string.info_card),
            )


        }
    }
}


@Preview
@Composable
private fun InfoCardPreview() {

    InfoCard(
        modifier = Modifier
    )

}