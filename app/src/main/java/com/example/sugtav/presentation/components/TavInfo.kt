@file:OptIn(ExperimentalMaterial3ExpressiveApi::class)

package com.example.sugtav.presentation.components

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Verified
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.Wallpapers
import androidx.compose.ui.unit.dp
import com.example.sugtav.R
import com.example.sugtav.domain.model.VehicleRecord
import com.example.sugtav.presentation.theme.SugtavTheme
import com.example.sugtav.presentation.util.formatDate
import com.example.sugtav.presentation.util.formatIsraeliVehicleNumber
import com.example.sugtav.presentation.util.getTagTypeInfo

@Composable
fun TavInfo(modifier: Modifier = Modifier, record: VehicleRecord) {

    val tagInfo = getTagTypeInfo(record.tagType)

    Card(
        modifier = modifier,
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp, start = 8.dp),
            ) {
                Icon(
                    modifier = Modifier
                        .size(50.dp),
                    imageVector = Icons.Default.Verified,
                    contentDescription = null,
                )


                Text(
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 58.dp),
                    style = MaterialTheme.typography.headlineLarge,
                    textAlign = TextAlign.Center,
                    text = "נמצא תו"
                )
            }

            HorizontalDivider(
                modifier = Modifier
                    .padding(start = 8.dp, end = 8.dp, bottom = 8.dp, top = 4.dp),
            )


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
                    text = formatIsraeliVehicleNumber(record.vehicleNumber)
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(imageVector = Icons.Default.DateRange, contentDescription = null)
                Text(
                    style = MaterialTheme.typography.labelLarge,
                    text = stringResource(R.string.issue_date)
                )
                Text(
                    text = formatDate(record.tagIssueDate),
                    style = MaterialTheme.typography.labelMedium

                )
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp, bottom = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(imageVector = Icons.Default.Info, contentDescription = null)
                Text(
                    style = MaterialTheme.typography.labelLarge,
                    text = stringResource(R.string.tag_type)
                )
                Text(
                    style = MaterialTheme.typography.labelMedium,
                    text = tagInfo.text
                )
                Image(
                    modifier = Modifier.size(90.dp),
                    painter = painterResource(tagInfo.imageRes), contentDescription = null
                )
            }
        }

    }
}


@Preview(
    showBackground = true,
    wallpaper = Wallpapers.BLUE_DOMINATED_EXAMPLE, showSystemUi = false,
    uiMode = Configuration.UI_MODE_TYPE_NORMAL
)
@Composable
private fun TavInfoPreview() {

    SugtavTheme {

        TavInfo(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp),
            record = VehicleRecord(
                id = 1,
                vehicleNumber = 5425245,
                tagIssueDate = 20251010,
                tagType = 2,
                rank = 0.25f
            )
        )
    }

}