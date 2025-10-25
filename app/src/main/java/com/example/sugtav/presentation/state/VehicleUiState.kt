package com.example.sugtav.presentation.state

import com.example.sugtav.domain.model.VehicleRecord

sealed class VehicleUiState {
    object Idle : VehicleUiState()
    object Loading : VehicleUiState()
    data class Success(val record: VehicleRecord) : VehicleUiState()
    data class Error(val message: String) : VehicleUiState()
}