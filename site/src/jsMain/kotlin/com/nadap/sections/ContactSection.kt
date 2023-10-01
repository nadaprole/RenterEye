package com.nadap.sections

import androidx.compose.runtime.*
import com.nadap.components.ContactForm
import com.nadap.components.SectionTtile
import com.nadap.models.Section
import com.nadap.util.Constants
import com.nadap.util.Constants.SECTION_WIDTH
import com.nadap.util.ObserveViewportEntered
import com.varabyte.kobweb.compose.css.CSSTransition
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.jetbrains.compose.web.ExperimentalComposeWebApi
import org.jetbrains.compose.web.css.deg
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px

@Composable
fun ContactSection(){
    Box(
        modifier = Modifier
            .id(Section.Contact.id)
            .maxWidth(SECTION_WIDTH.px)
            .padding(topBottom = 100.px),
        contentAlignment = Alignment.Center
    ) {
        ContactContent()
    }
}

@OptIn(ExperimentalComposeWebApi::class)
@Composable
fun ContactContent(){
    val breakpoint by rememberBreakpoint()
    var scope = rememberCoroutineScope()
    var animatedRotation by remember { mutableStateOf(0.deg) }

    ObserveViewportEntered(
        sectionId = Section.Contact.id,
        distanceFromTop = 500.0,
        onViewportEntered = {
            animatedRotation = 10.deg
            scope.launch {
                delay(500)
                animatedRotation = 0.deg
            }
        }
    )
    Column(
        modifier = Modifier.fillMaxWidth(
            if (breakpoint >= Breakpoint.MD) 100.percent
            else 90.percent),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        SectionTtile(
            modifier = Modifier
                .fillMaxWidth()
                .margin(bottom = 25.px)
                .transform {rotate(animatedRotation)}
                .transition(CSSTransition(property = "transform", duration = 500.ms)),
            section = Section.Contact,
            alignment = Alignment.CenterHorizontally
        )
        ContactForm(breakpoint = breakpoint)
}

}