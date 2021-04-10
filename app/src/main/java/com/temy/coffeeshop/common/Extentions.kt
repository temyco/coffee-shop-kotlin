package com.temy.coffeeshop.common

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import java.text.DecimalFormat
import java.util.*

fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)
}

fun <Long> Long.toPriceFormat(currency: String = "$"): String {
    return DecimalFormat("$currency #.00").format(this)
}