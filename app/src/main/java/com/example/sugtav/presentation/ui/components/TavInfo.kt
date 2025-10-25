package com.example.sugtav.presentation.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.DirectionsCar
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Verified
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sugtav.domain.model.VehicleRecord
import com.example.sugtav.presentation.util.formatDate

@Composable
fun TavInfo(modifier: Modifier = Modifier, record: VehicleRecord) {
    Card(
        modifier = modifier,
    ) {
        Column (
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ){

            Icon(
                modifier = Modifier.size(50.dp),
                imageVector = Icons.Default.Verified,
                contentDescription = null
            )

            Row (
                modifier = Modifier.fillMaxWidth(),
            ){
                Icon(
                    modifier = Modifier
                        .size(50.dp)
                        .padding(start = 8.dp),
                    imageVector = Icons.Default.DirectionsCar,
                    contentDescription = null
                )

                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.CenterVertically)
                        .padding(end = 16.dp),
                    style = MaterialTheme.typography.titleLarge,
                    textAlign = TextAlign.Center,
                    text = "${record.vehicleNumber}"
                )
            }
            Spacer(modifier =
                Modifier
                    .padding(8.dp)
                    .width(3.dp))
            Column (
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Icon(imageVector = Icons.Default.DateRange, contentDescription = null)
                Text(
                    style = MaterialTheme.typography.titleMedium,
                    text = ":תאריך הנפקה"
                )
                Text(text = formatDate(record.tagIssueDate))
            }

            Column (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp, bottom = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Icon(imageVector = Icons.Default.Info, contentDescription = null)
                Text(
                    style = MaterialTheme.typography.titleMedium,
                    text = ":סוג תג"
                )
                Text(text = "${record.tagType}")
            }
        }

    }
}

//
//@Preview(showBackground = true)
//@Composable
//private fun TavInfoPreview() {
//
//    TavInfo(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(24.dp),
//        record = VehicleRecord(
//            id = 1,
//            vehicleNumber = 5425245,
//            tagIssueDate = 20251010,
//            tagType = 1,
//            rank = 0.25
//        )
//    )
//
//}