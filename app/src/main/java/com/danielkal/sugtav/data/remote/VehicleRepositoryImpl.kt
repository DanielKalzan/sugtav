package com.danielkal.sugtav.data.remote

import com.danielkal.sugtav.data.remote.api.DataGovApi
import com.danielkal.sugtav.data.remote.dto.toDomain
import com.danielkal.sugtav.domain.model.VehicleRecord
import com.danielkal.sugtav.domain.repository.VehicleRepository

class VehicleRepositoryImpl (
    private val api: DataGovApi = RetrofitInstance.api
) : VehicleRepository {
    private val resourceId = "c8b9f9c8-4612-4068-934f-d4acd2e3c06e"
    override suspend fun searchVehicle(vehicleNumber: String): Result<VehicleRecord?> {
        return try {
            val response = api.searchVehicle(resourceId, vehicleNumber)
            if (response.success){
                val record = response.result.records.firstOrNull()?.toDomain()
                Result.success(record)
            } else {
                Result.failure(Exception("No results found"))
            }
        } catch (e: Exception){
            Result.failure(e)
        }
    }
}