package com.nadap.models

import com.nadap.util.Res

enum class Achievement(
    val icon: String,
    val number: Int,
    val description: String
) {
    Completed(
        icon = Res.Image.checkmark,
        number = 120,
        description = "Complited Projects"
    ),
    Active(
        icon = Res.Image.shield,
        number = 12,
        description = "Active Projects"
    ),
    Satisfied(
        icon = Res.Image.happy,
        number = 42,
        description = "Satisfied Clients"
    ),
    Team(
        icon = Res.Image.user,
        number = 10,
        description = "Team Members"
    ),
}