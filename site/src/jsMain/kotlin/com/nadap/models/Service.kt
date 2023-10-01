package com.nadap.models

import com.nadap.util.Constants.LOREM_IPSUM_SHORTEST
import com.nadap.util.Res

enum class Service(
    val image: String,
    val imageDesc: String,
    val title: String,
    val description: String
) {
    RentPropertyInsection(
        image = Res.Image.rent_inspection_image,
        imageDesc = "Rent Inspection Image",
        title = "Rent Property Inspection",
        description = LOREM_IPSUM_SHORTEST
    ),
    HomeInsection(
        image = Res.Image.home_inspection_image,
        imageDesc = "Home Inspection Image",
        title = "Home Inspection",
        description = LOREM_IPSUM_SHORTEST
    ),
    BusinessPropertyInsection(
        image = Res.Image.business_inspection_image,
        imageDesc = "Business Inspection Image",
        title = "Business Property Inspection",
        description = LOREM_IPSUM_SHORTEST
    )
}