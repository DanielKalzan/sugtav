package com.danielkal.sugtav.presentation.util


fun formatDate(date: Int): String {
    val dateStr = date.toString()
    return if (dateStr.length == 8) {
        "${dateStr.substring(6, 8)}/${dateStr.substring(4, 6)}/${dateStr.substring(0, 4)}"
    } else {
        dateStr
    }
}

fun formatIsraeliVehicleNumber(vehicleNumber: Long): String {
    val numberStr = vehicleNumber.toString()

    return when (numberStr.length) {
        5 -> {
            // 12-345
            "${numberStr.substring(0, 2)}-${numberStr.substring(2)}"
        }

        6 -> {
            // 12-345-6
            "${numberStr.substring(0, 2)}-${numberStr.substring(2, 5)}-${numberStr.substring(5)}"
        }

        7 -> {
            // 12-345-67
            "${numberStr.substring(0, 2)}-${numberStr.substring(2, 5)}-${numberStr.substring(5)}"
        }

        8 -> {
            // 123-45-678
            "${numberStr.substring(0, 3)}-${numberStr.substring(3, 5)}-${numberStr.substring(5)}"
        }

        else -> {
            // Return as-is if not in standard format
            numberStr
        }
    }
}

fun formatIsraeliVehicleNumber(vehicleNumber: String): String {
    val numberStr = vehicleNumber

    return when (numberStr.length) {
        5 -> {
            // 12-345
            "${numberStr.substring(0, 2)}-${numberStr.substring(2)}"
        }

        6 -> {
            // 12-345-6
            "${numberStr.substring(0, 2)}-${numberStr.substring(2, 5)}-${numberStr.substring(5)}"
        }

        7 -> {
            // 12-345-67
            "${numberStr.substring(0, 2)}-${numberStr.substring(2, 5)}-${numberStr.substring(5)}"
        }

        8 -> {
            // 123-45-678
            "${numberStr.substring(0, 3)}-${numberStr.substring(3, 5)}-${numberStr.substring(5)}"
        }

        else -> {
            // Return as-is if not in standard format
            numberStr
        }
    }
}
