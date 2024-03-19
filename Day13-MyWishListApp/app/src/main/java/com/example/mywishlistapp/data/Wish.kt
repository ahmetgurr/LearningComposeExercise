package com.example.mywishlistapp.data

data class Wish(
    val id: Long = 0L,
    val title: String= "",
    val description: String = ""
)

object DummyWish {
    val wishList = listOf(
        Wish(title = "Tesla Model S", description = "Tesla Model S Plaid"),
        Wish(title = "Tesla Model 3", description = "Tesla Model 3 Long Range"),
        Wish(title = "Tesla Model X", description = "Tesla Model X Plaid")
    )
}
