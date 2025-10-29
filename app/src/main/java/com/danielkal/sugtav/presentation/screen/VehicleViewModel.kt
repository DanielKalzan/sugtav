package com.danielkal.sugtav.presentation.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.danielkal.sugtav.data.remote.VehicleRepositoryImpl
import com.danielkal.sugtav.domain.usecase.SearchVehicleUseCase
import com.danielkal.sugtav.presentation.state.VehicleUiState
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

    fun restartState(){
        _uiState.value = VehicleUiState.Idle
    }

}