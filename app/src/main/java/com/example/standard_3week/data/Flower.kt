package com.example.standard_3week.data

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.parcelize.Parcelize

@Parcelize
data class Flower(
    val id: Int,
    val name: String,

    @DrawableRes
    val image: Int,
    val description: String,
) : Parcelable