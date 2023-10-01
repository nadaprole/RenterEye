package com.nadap.models

import com.nadap.util.Res

enum class Portfolio(
    val image: String,
    val title: String,
    val description: String
) {
    One(
        image = Res.Image.portfolio1,
        title = "Rent Inspection",
        description = "Inspect your property before you rent"
    ),
    Two(
        image = Res.Image.portfolio2,
        title = "Home inspection",
        description = "Do home inspection before you buy"
    ),
    Three(
        image = Res.Image.portfolio3,
        title = "Bussines Inspection",
        description = "Inspect bussines property before you rent or buy"
    ),
    Four(
        image = Res.Image.portfolio4,
        title = "Pool Inspection",
        description = "Inspect your pool"
    ),
}