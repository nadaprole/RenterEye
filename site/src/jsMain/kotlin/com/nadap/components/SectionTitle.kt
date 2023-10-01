package com.nadap.components

import androidx.compose.runtime.*
import com.nadap.models.Section
import com.nadap.models.Theme
import com.nadap.util.Constants
import com.nadap.util.ObserveViewportEntered
import com.varabyte.kobweb.compose.css.CSSTransition
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun SectionTtile(
    modifier: Modifier = Modifier,
    section: Section,
    alignment: Alignment.Horizontal = Alignment.Start
){
    val scope = rememberCoroutineScope()
    var titleMargin by remember { mutableStateOf(100.px) }
    var subtitleMargin by remember { mutableStateOf(100.px) }

    ObserveViewportEntered(
        sectionId = section.id,
        distanceFromTop = 700.0,
        onViewportEntered = {
            scope.launch {
                subtitleMargin = 0.px
                if (alignment == Alignment.Start){
                    delay(50)
                }
                if (alignment == Alignment.CenterHorizontally){
                    delay(50)
                }
                titleMargin = 0.px
            }
        }
    )


    Column(modifier = modifier, horizontalAlignment = alignment) {
        P(
            attrs = Modifier
                .fontFamily(Constants.FONT_FAMILY)
                .fillMaxWidth()
                .margin(
                    left = titleMargin,
                    top = 0.px,
                    bottom = 0.px)
                .textAlign(
                    when (alignment) {
                        Alignment.CenterHorizontally -> TextAlign.Center
                        Alignment.End -> TextAlign.End
                        else -> TextAlign.Start
                    }
                )
                .fontSize(25.px)
                .fontWeight(FontWeight.Normal)
                .color(Theme.Primary.rgb)
                .transition(CSSTransition(property = "margin", duration = 1000.ms))
                .toAttrs()
        ) {
            Text(section.title)
        }
        P(
            attrs = Modifier
                .fontFamily(Constants.FONT_FAMILY)
                .fillMaxWidth()
                .margin(
                    left = if (alignment == Alignment.Start) subtitleMargin else 0.px,
                    right = if (alignment == Alignment.CenterHorizontally) subtitleMargin else 0.px,
                    bottom = 10.px,
                    top = 0.px)
                .textAlign(
                    when (alignment) {
                        Alignment.CenterHorizontally -> TextAlign.Center
                        Alignment.End -> TextAlign.End
                        else -> TextAlign.Start
                    }
                )
                .fontSize(40.px)
                .fontWeight(FontWeight.Bold)
                .color(Theme.Secondary.rgb)
                .transition(CSSTransition(property = "margin", duration = 1000.ms))
                .toAttrs()
        ) {
            Text(section.subtitle)
        }
        Box(
            modifier = Modifier
                .height(2.px)
                .width(80.px)
                .backgroundColor(Theme.Primary.rgb)
                .borderRadius(r = 50.px)
        )


    }
}