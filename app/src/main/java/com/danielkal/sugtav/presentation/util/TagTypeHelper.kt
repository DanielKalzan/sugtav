package com.danielkal.sugtav.presentation.util

import androidx.annotation.DrawableRes
import com.danielkal.sugtav.R

data class TagTypeInfo(
    val text: String,
    @DrawableRes val imageRes: Int
)

fun getTagTypeInfo(tagType: Int): TagTypeInfo {
    return when (tagType) {
        1 -> TagTypeInfo(
            text = "תו נכה רגיל",
            imageRes = R.drawable.standard_tag
        )
        2 -> TagTypeInfo(
            text = "תו נכה כיסא",
            imageRes = R.drawable.chair_tag
        )
        else -> TagTypeInfo(
            text = "תו לא ידוע", // Unknown tag
            imageRes = R.drawable.car_icon
        )
    }
}