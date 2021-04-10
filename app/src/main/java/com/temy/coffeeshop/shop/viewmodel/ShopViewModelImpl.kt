package com.temy.coffeeshop.shop.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.temy.coffeeshop.model.Product
import com.temy.coffeeshop.model.ShopRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ShopViewModelImpl @Inject constructor(
    private val shopRepository: ShopRepository
) : ViewModel(), ShopViewModel {

    override val productList = MutableLiveData<List<Product>>()

    init {
        updateState()
    }

    private fun updateState() {
        productList.value = shopRepository.getMockProducts()
    }
}