package com.nadap.models

import org.jetbrains.compose.web.css.CSSSizeValue
import org.jetbrains.compose.web.css.CSSUnit
import org.jetbrains.compose.web.css.percent

enum class Skill(
    val title: String,
    val percentage: CSSSizeValue<CSSUnit.percent>
) {

    Inspection(
        title = "Property Inspections",
        percentage = 90.percent
    ),
    Communication(
        title = "Effective Communication",
        percentage = 80.percent
    ),
    Proficiency(
        title = "Technological Proficiency",
        percentage = 75.percent
    ),
    Regulations(
        title = "Knowledge of Regulations",
        percentage = 85.percent
    ),
    Customer(
        title = "Customer Service",
        percentage = 95.percent
    )
}