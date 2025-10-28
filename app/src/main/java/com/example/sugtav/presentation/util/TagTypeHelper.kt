package com.example.sugtav.presentation.util

import androidx.annotation.DrawableRes
import com.example.sugtav.R

data class TagTypeInfo(
    val text: String,
    @DrawableRes val imageRes: Int
)

fun getTagTypeInfo(tagType: Int): TagTypeInfo {
    return when (tagType) {
        1 -> TagTypeInfo(
            text = "תג נכה רגיל", // White tag
            imageRes = R.drawable.standard_tag
        )
        2 -> TagTypeInfo(
            text = "תג נכה כיסא", // Green tag
            imageRes = R.drawable.chair_tag
        )
        else -> TagTypeInfo(
            text = "תו לא ידוע", // Unknown tag
            imageRes = R.drawable.car_icon // Fallback image
        )
    }
}