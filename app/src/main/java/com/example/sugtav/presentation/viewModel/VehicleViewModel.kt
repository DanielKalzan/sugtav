package com.example.sugtav.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sugtav.data.remote.VehicleRepositoryImpl
import com.example.sugtav.domain.usecase.SearchVehicleUseCase
import com.example.sugtav.presentation.state.VehicleUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class VehicleViewModel (
    private val searchVehicleUseCase: SearchVehicleUseCase = SearchVehicleUseCase(
        VehicleRepositoryImpl()
    )
) : ViewModel() {

    private val _uiState = MutableStateFlow<VehicleUiState>(VehicleUiState.Idle)
    val uiState: StateFlow<VehicleUiState> = _uiState.asStateFlow()

    fun searchVehicle(vehicleNumber: String) {
        viewModelScope.launch {
            _uiState.value = VehicleUiState.Loading

            searchVehicleUseCase(vehicleNumber)
                .onSuccess { record ->
                    _uiState.value = if (record == null){
                        VehicleUiState.Error("No record found")
                    } else {
                        VehicleUiState.Success(record)
                    }
                }
                .onFailure { error ->
                    _uiState.value = VehicleUiState.Error(
                        error.message ?: "Something went wrong"
                    )
                }
        }
    }


}