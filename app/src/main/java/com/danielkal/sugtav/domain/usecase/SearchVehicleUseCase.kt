package com.danielkal.sugtav.domain.usecase

import com.danielkal.sugtav.domain.model.VehicleRecord
import com.danielkal.sugtav.domain.repository.VehicleRepository

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