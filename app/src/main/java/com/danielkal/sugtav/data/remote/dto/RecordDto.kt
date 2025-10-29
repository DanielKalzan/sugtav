package com.danielkal.sugtav.data.remote.dto

import com.danielkal.sugtav.domain.model.VehicleRecord
import com.google.gson.annotations.SerializedName


data class RecordDto(
    val _id: Int,
    @SerializedName("MISPAR RECHEV") val misparRechev: Long,
    @SerializedName("TAARICH HAFAKAT TAG") val taarichHfakatTag: Int,
    @SerializedName("SUG TAV") val sugTav: Int,
    val rank: Float
)

fun RecordDto.toDomain() = VehicleRecord(
    id = _id,
    vehicleNumber = misparRechev,
    tagIssueDate = taarichHfakatTag,
    tagType = sugTav,
    rank = rank
)
