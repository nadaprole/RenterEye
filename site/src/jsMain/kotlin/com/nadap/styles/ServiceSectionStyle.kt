package com.nadap.styles

import com.nadap.models.Theme
import com.varabyte.kobweb.compose.css.CSSTransition
import com.varabyte.kobweb.compose.css.TransitionProperty
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.hover
import org.jetbrains.compose.web.ExperimentalComposeWebApi
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Th

@OptIn(ExperimentalComposeWebApi::class)
val ServiceImageStyle by ComponentStyle {
    base {
        Modifier.styleModifier { filter { grayscale(100.percent) } }
            .borderRadius(r = 0.px)
            //.rotate(0.deg)
            .transition(CSSTransition(property = TransitionProperty.All, duration = 200.ms))
    }
    hover {
        Modifier.styleModifier { filter { grayscale(0.percent) } }
//            .borderRadius(r = 100.px)
        //.rotate(10.deg)
    }
}

val ServiceCardStyle by ComponentStyle {
    base {
        Modifier.border(width = 2.px,
        style = LineStyle.Solid,
        color = Theme.LighterGray.rgb)
            .backgroundColor(Colors.White)
            .transition(
                CSSTransition(property = "border", duration = 200.ms),
                CSSTransition(property = "background", duration = 200.ms)
            )
    }
    hover{
        Modifier.border(width = 2.px,
            style = LineStyle.Solid,
            color = Theme.Primary.rgb)
            .backgroundColor(Theme.Primary.rgb)
    }

//    cssRule(" > #iconBox"){
//        Modifier.backgroundColor(Colors.Transparent)
//            .transition(
//                CSSTransition(property = "background", duration = 200.ms))
//    }
//
//    cssRule(":hover > #iconBox"){
//        Modifier.backgroundColor(Colors.White)
//    }

    cssRule(" > p"){
        Modifier.color(Theme.Secondary.rgb)
            .transition(
                CSSTransition(property = "color", duration = 200.ms))
    }

    cssRule(":hover > p"){
        Modifier.color(Colors.White)
    }
}