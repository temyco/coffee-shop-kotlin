package com.temy.coffeeshop.shop.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import com.temy.coffeeshop.model.ShopRepository
import io.mockk.*
import org.junit.Before
import org.junit.Test
import org.junit.Assert.*
import org.junit.Rule

class ShopViewModelImplTest {
    @Rule
    @JvmField
    var instantTaskExecutorRule: InstantTaskExecutorRule = InstantTaskExecutorRule()

    private val repository = mockk<ShopRepository>()

    private lateinit var viewModel: ShopViewModelImpl

    @Before
    fun setup() {
        mockkConstructor(MutableLiveData::class)

        every { repository.getMockProducts() } returns emptyList()

        viewModel = spyk(ShopViewModelImpl(repository))
    }

    @Test
    fun `GIVEN viewmodel WHEN init THEN product list updated`() {
        verify { repository.getMockProducts() }

        assertNotEquals(viewModel.productList.value, null)
    }
}