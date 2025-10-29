package com.danielkal.sugtav.domain.repository

import com.danielkal.sugtav.domain.model.VehicleRecord

interface VehicleRepository {
    suspend fun searchVehicle(vehicleNumber: String): Result<VehicleRecord?>
}