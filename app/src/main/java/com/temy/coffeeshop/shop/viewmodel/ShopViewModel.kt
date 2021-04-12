package com.temy.coffeeshop.shop.viewmodel

import androidx.lifecycle.MutableLiveData
import com.temy.coffeeshop.model.Product

interface ShopViewModel {
    val productList: MutableLiveData<List<Product>>
}