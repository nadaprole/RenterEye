package com.nadap.sections

import androidx.compose.runtime.*
import com.nadap.models.Section
import com.nadap.models.Theme
import com.nadap.util.Constants
import com.nadap.util.Constants.SECTION_WIDTH
import com.nadap.util.ObserveViewportEntered
import com.varabyte.kobweb.compose.css.CSSTransition
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun TestSection(){
    Box(
        modifier = Modifier
            .id(Section.Test.id)
            .maxWidth(SECTION_WIDTH.px)
            .padding(topBottom = 100.px),
        contentAlignment = Alignment.Center
    ) {
       TestContent()
    }
}

@Composable
fun TestContent(){

    var animatedMargin by remember { mutableStateOf(200.px) }

    ObserveViewportEntered(
        sectionId = Section.Test.id,
        distanceFromTop = 500.0,
        onViewportEntered = {
            animatedMargin = 50.px
        }
    )

    Column(
        modifier = Modifier
            .fillMaxSize(60.percent),
        verticalArrangement = Arrangement.Center,
    ) {
        P (
            attrs = Modifier
                .margin(left =  animatedMargin, bottom = 50.px)
                .transition(
                    CSSTransition(
                        property = "margin",
                        duration = 500.ms,
                        delay =  100.ms
                    )
                )
                .fontFamily(Constants.FONT_FAMILY)
                .fontSize(20.px)
                .fontWeight(FontWeight.Bold)
                .color(Theme.Secondary.rgb)
                .toAttrs()
        ) {
            Text("Lorem ipsum dolor sit amet")
        }
        P (
            attrs = Modifier
                .margin(left =  animatedMargin, bottom = 50.px)
                .transition(
                    CSSTransition(
                        property = "margin",
                        duration = 500.ms,
                        delay =  300.ms
                    )
                )
                .fontFamily(Constants.FONT_FAMILY)
                .fontSize(14.px)
                .fontWeight(FontWeight.Normal)
                .color(Theme.Secondary.rgb)
                .toAttrs()
        ) {
            Text("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt")
        }
        P (
            attrs = Modifier
                .fillMaxWidth()
                .margin(left =  animatedMargin, bottom = 50.px)
                .transition(
                    CSSTransition(
                        property = "margin",
                        duration = 500.ms,
                        delay =  500.ms
                    )
                )
                .fontFamily(Constants.FONT_FAMILY)
                .fontSize(14.px)
                .fontWeight(FontWeight.Normal)
                .color(Theme.Primary.rgb)
                .toAttrs(),
        ) {
            Text("Lorem ipsum dolor sit amet, consectetur adipiscing elit, " +
                    "sed do eiusmod tempor incididunt ut labore et dolore magna " +
                    "aliqua. Ut enim ad minim veniam, quis nostrud exercitation " +
                    "ullamco laboris nisi ut aliquip ex ea commodo consequat")
        }
    }
}