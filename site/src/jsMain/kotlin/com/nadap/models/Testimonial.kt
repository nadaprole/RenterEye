package com.nadap.models

import com.nadap.util.Constants.LOREM_IPSUM_SHORT
import com.nadap.util.Res

enum class Testimonial(
    val image: String,
    val fullName: String,
    val profession: String,
    val review: String
) {
    First(
        image = Res.Image.avatar2,
        fullName = "Rade Blazic",
        profession = "Airbnb owner",
        review = LOREM_IPSUM_SHORT
    ),
    Second(
        image = Res.Image.avatar1,
        fullName = "Nada Blazic",
        profession = "Airbnb owner",
        review = LOREM_IPSUM_SHORT
    ),
    Third(
        image = Res.Image.avatar4,
        fullName = "Jon Berry",
        profession = "Airbnb owner",
        review = LOREM_IPSUM_SHORT
    ),
    Fourth(
        image = Res.Image.avatar3,
        fullName = "Ann Cock",
        profession = "Airbnb owner",
        review = LOREM_IPSUM_SHORT
    ),
    Fift(
        image = Res.Image.avatar5,
        fullName = "Sebastian Smith",
        profession = "Airbnb owner",
        review = LOREM_IPSUM_SHORT
    ),
    Sixth(
        image = Res.Image.avatar6,
        fullName = "Robert Jones",
        profession = "Airbnb owner",
        review = LOREM_IPSUM_SHORT
    ),
}