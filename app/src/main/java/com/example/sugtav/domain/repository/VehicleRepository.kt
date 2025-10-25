package com.example.sugtav.domain.repository

import com.example.sugtav.domain.model.VehicleRecord

interface VehicleRepository {
    suspend fun searchVehicle(vehicleNumber: String): Result<VehicleRecord?>
}