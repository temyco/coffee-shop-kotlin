package com.temy.coffeeshop.model

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ShopRepository @Inject constructor() {
    private val mockList = listOf(
        Product(
            "Espresso",
            "That's coffee",
            12L,
            Product.Type("Coffee"),
            Product.CaffeineLevel.HIGH
        ),
        Product(
            "Latte",
            "That's latte",
            18L,
            Product.Type("Coffee"),
            Product.CaffeineLevel.LOW
        ),
        Product(
            "No caffeine Latte",
            "That's latte",
            18L,
            Product.Type("Coffee"),
            Product.CaffeineLevel.NO_CAFFEINE
        ),
        Product(
            "Latte",
            "That's latte",
            18L,
            Product.Type("Coffee"),
            Product.CaffeineLevel.LOW
        ),
        Product(
            "Latte",
            "That's latte",
            18L,
            Product.Type("Coffee"),
            Product.CaffeineLevel.LOW
        ),
        Product(
            "Chocolate Cookie",
            "That's yummy",
            4L,
            Product.Type("Cookies")
        ),
        Product(
            "Biscuit",
            "That's yummy",
            12L,
            Product.Type("Cookies")
        ),
        Product(
            "Americano",
            "That's also coffee",
            18L,
            Product.Type("Coffee"),
            Product.CaffeineLevel.MEDIUM
        ),
        Product(
            "Other 1",
            "That's also coffee",
            18L,
            Product.Type("Other")
        ),
        Product(
            "Other 2 ",
            "That's also coffee",
            18L,
            Product.Type("Other")
        ),
        Product(
            "Other 3",
            "That's also coffee",
            18L,
            Product.Type("Other 3")
        ),
        Product(
            "Other 4",
            "That's also coffee",
            18L,
            Product.Type("Other 4")
        ),
        Product(
            "Other 5",
            "That's also coffee",
            18L,
            Product.Type("Other 5")
        ),
        Product(
            "Other 6",
            "That's also coffee",
            18L,
            Product.Type("Other")
        ),
        Product(
            "Other 7",
            "That's also coffee",
            18L,
            Product.Type("Other")
        )
    )

    fun getMockProducts(): List<Product> {
        return mockList
    }
}