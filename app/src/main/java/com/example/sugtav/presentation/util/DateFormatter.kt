package com.example.sugtav.presentation.util


    fun formatDate(date: Int): String{
        val dateStr = date.toString()
        return if (dateStr.length == 8){
            "${dateStr.substring(6,8)}/${dateStr.substring(4,6)}/${dateStr.substring(0,4)}}"
        } else{
            dateStr
        }
    }
