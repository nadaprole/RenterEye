package com.nadap.sections

import androidx.compose.runtime.*
import com.nadap.components.SectionTtile
import com.nadap.components.SkillBar
import com.nadap.models.Section
import com.nadap.models.Skill
import com.nadap.models.Theme
import com.nadap.styles.AboutImageStyle
import com.nadap.styles.AboutTextStyle
import com.nadap.util.Constants.FONT_FAMILY
import com.nadap.util.Constants.SECTION_WIDTH
import com.nadap.util.ObserveViewportEntered
import com.nadap.util.Res
import com.nadap.util.animateNumbers
import com.varabyte.kobweb.compose.css.FontStyle
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import kotlinx.coroutines.launch
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun AboutSection() {
    Box(
        modifier = Modifier
            .id(Section.About.id)
            .maxWidth(SECTION_WIDTH.px)
            .padding(topBottom = 150.px),
        contentAlignment = Alignment.Center
    ) {
        AboutContent()
    }
}

@Composable
fun AboutContent(){
    val breakpoint by rememberBreakpoint()
    Column(
        modifier = Modifier.fillMaxWidth(
            if (breakpoint >= Breakpoint.MD) 100.percent
            else 90.percent)
            .maxWidth(1200.px),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SimpleGrid(
            modifier = Modifier.fillMaxWidth(
                if (breakpoint >= Breakpoint.MD) 90.percent
                else 100.percent
            ),
            numColumns = numColumns(base = 1, md = 2)){
            if (breakpoint >= Breakpoint.MD){
                AboutImage()
            }
            AboutMe()
        }
    }
}

@Composable
fun AboutImage(){
    Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
        Image(
            modifier = AboutImageStyle.toModifier().fillMaxWidth(60.percent)
                .borderRadius(
                    topLeft = 24.px,
                    topRight = 24.px,
                    bottomLeft = 24.px,
                    bottomRight = 24.px),
            src = Res.Image.about_image,
            desc = "About Image"
        )
    }
}

@Composable
fun AboutMe(){
    val scope = rememberCoroutineScope()
    var viewportEntered by remember { mutableStateOf(false) }
    val animatedPercentage = remember { mutableStateListOf(0,0,0,0,0) }
    ObserveViewportEntered(
        sectionId = Section.About.id,
        distanceFromTop = 300.0,
        onViewportEntered = {
            viewportEntered = true
            Skill.values().forEach { skill ->
                scope.launch {
                    animateNumbers(
                        number = skill.percentage.value.toInt(),
                        onUpdate = {
                            animatedPercentage[skill.ordinal] = it
                        }
                    )
                }
            }
        }
    )

    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center
    ) {
        SectionTtile(section = Section.About)
        P (
            attrs = AboutTextStyle.toModifier()
                .margin(topBottom = 25.px)
                .maxWidth(500.px)
                .fontFamily(FONT_FAMILY)
                .fontSize(18.px)
                .fontWeight(FontWeight.Normal)
                .fontStyle(FontStyle.Italic)
                .color(Theme.Secondary.rgb)
                .toAttrs()
        ){
            Text("Welcome to Renter's eye, your trusted partner for rental property inspections. With years of experience in the industry, we pride ourselves on delivering thorough and reliable property assessments to property owners, landlords, and property management companies.")
        }
        Skill.values().forEach { skill ->
            SkillBar(
                name = skill.title,
                index = skill.ordinal,
                percentage = if (viewportEntered) skill.percentage else 0.percent,
                animatedPercentage = if(viewportEntered) animatedPercentage[skill.ordinal] else 0
            )
        }
    }
}