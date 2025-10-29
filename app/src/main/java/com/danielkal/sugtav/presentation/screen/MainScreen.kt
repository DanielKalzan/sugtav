package com.danielkal.sugtav.presentation.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ContainedLoadingIndicator
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.text.isDigitsOnly
import androidx.lifecycle.viewmodel.compose.viewModel
import com.danielkal.sugtav.R
import com.danielkal.sugtav.presentation.components.InfoCard
import com.danielkal.sugtav.presentation.components.NotFound
import com.danielkal.sugtav.presentation.components.TavInfo
import com.danielkal.sugtav.presentation.state.VehicleUiState


@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    viewModel: VehicleViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    var carNumber by remember { mutableStateOf("") }


    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        when (val state = uiState) {
            is VehicleUiState.Idle -> {
                OutlinedTextField(
                    value = carNumber,
                    onValueChange = {
                        if (it.length <= 8 && it.isDigitsOnly()) {
                            carNumber = it
                        }
                    },
                    label = {
                        Text(text = stringResource(R.string.car_number))
                    },
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    isError = carNumber.isNotEmpty() && (carNumber.length < 5 || carNumber.length > 8),
                    supportingText = {
                        if (carNumber.isNotEmpty() && (carNumber.length < 5 || carNumber.length > 8)) {
                            Text(text = stringResource(R.string.car_number_must_length))
                        }
                    }
                )

                Button(
                    onClick = { viewModel.searchVehicle(carNumber) },
                    enabled = carNumber.length >= 5 && carNumber.length <= 8
                ) {
                    Text(text = stringResource(R.string.check_car))
                }
            }

            is VehicleUiState.Error -> {
                if (state.message.contains("No record found")) {
                    NotFound(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        carNumber = carNumber
                    )
                } else{
                    Text(text = state.message)
                }

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = {
                        carNumber = ""
                        viewModel.restartState()
                    }
                ) {
                    Text(stringResource(R.string.searchDifferentCar))
                }
            }

            is VehicleUiState.Loading -> {
                ContainedLoadingIndicator(
                    modifier = Modifier.size(100.dp),
                )
            }

            is VehicleUiState.Success -> {
                TavInfo(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(24.dp),
                    record = state.record
                )

                Spacer(modifier = Modifier.height(16.dp))

                // New Search Button after results
                Button(
                    onClick = {
                        carNumber = ""
                        viewModel.restartState()
                    }
                ) {
                    Text(stringResource(R.string.searchDifferentCar))
                }
            }
        }

        InfoCard(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )
    }
}


@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun MainScreenPreview() {

    MainScreen(
        modifier = Modifier.fillMaxWidth(),
    )

}