package com.example.sugtav.domain.usecase

import com.example.sugtav.domain.model.VehicleRecord
import com.example.sugtav.domain.repository.VehicleRepository

class SearchVehicleUseCase(
    private val repository: VehicleRepository
) {
    suspend operator fun invoke(vehicleNumber: String): Result<VehicleRecord?>{
        if (vehicleNumber.isBlank()){
            return Result.failure(Exception("The vehicle number can't be empty"))
        }
        return repository.searchVehicle(vehicleNumber)
    }

}