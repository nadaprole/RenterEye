package com.nadap.models

import com.nadap.util.Constants.LOREM_IPSUM_LONG

enum class Experience(
    val number: String,
    val jobPosition: String,
    val description: String,
    val company: String,
    val from: String,
    val to: String
) {
    First(
        number = "01",
        jobPosition = "Home Inspector",
        description = LOREM_IPSUM_LONG,
        company = "Top Construction",
        from = "February 2022",
        to = "present"
    ),
    Second(
        number = "02",
        jobPosition = "Construction Lead",
        description = LOREM_IPSUM_LONG,
        company = "Hope Construction LLC",
        from = "January 2021",
        to = "January 2022"
    ),
    Third(
        number = "03",
        jobPosition = "Construction Helper",
        description = LOREM_IPSUM_LONG,
        company = "Consulting LLC",
        from = "May 2019",
        to = "December 2020"
    )
}