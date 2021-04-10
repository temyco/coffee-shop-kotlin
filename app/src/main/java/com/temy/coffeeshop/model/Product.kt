package com.temy.coffeeshop.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Product(
    val name: String,
    val description: String,
    val price: Long,
    val type: Type,
    val caffeineLevel: CaffeineLevel? = null
) : Parcelable {
    @Parcelize
    data class Type(val name: String) : Parcelable

    enum class CaffeineLevel {
        NO_CAFFEINE,
        LOW,
        MEDIUM,
        HIGH
    }
}