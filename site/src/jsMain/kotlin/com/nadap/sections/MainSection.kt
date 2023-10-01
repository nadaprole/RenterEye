package com.nadap.sections

import androidx.compose.runtime.Composable
import com.nadap.components.Header
import com.nadap.components.SocialBar
import com.nadap.models.Section
import com.nadap.models.Theme
import com.nadap.styles.MainButtonStyle
import com.nadap.styles.MainImageStyle
import com.nadap.util.Constants.FONT_FAMILY
import com.nadap.util.Constants.SECTION_WIDTH
import com.nadap.util.Res
import com.varabyte.kobweb.compose.css.*
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun MainSection(onMenuClicked: () -> Unit){
    Box(
        modifier = Modifier
            .id(Section.Home.id)
            .maxWidth(SECTION_WIDTH.px),
        contentAlignment = Alignment.TopCenter
    ) {
        MainBacground()
        MainContent(onMenuClicked = onMenuClicked)
    }
}

@Composable
fun MainBacground(){

    Image(
        modifier = Modifier.fillMaxSize().objectFit(ObjectFit.Cover),
        src = Res.Image.background,
        desc = "Background Image"
    )
}

@Composable
fun MainContent(onMenuClicked: () -> Unit){
    val breakpoint by rememberBreakpoint()
    Column (modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally){
        Header(onMenuClicked = onMenuClicked)
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SimpleGrid(modifier = Modifier.fillMaxWidth(
                if (breakpoint>=Breakpoint.MD) 80.percent
                else 90.percent
            ),
                numColumns = numColumns(base = 1, md = 2)
            ){
                MainText(breakpoint)
                MainImage()
            }
        }
    }
}

@Composable
fun MainText(breakpoint: Breakpoint){
    Row (
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ){
        if(breakpoint >= Breakpoint.MD){
            SocialBar()
        }
        Column {
            P (
                attrs = Modifier
                    .margin(topBottom = 0.px)
                    .fontFamily(FONT_FAMILY)
                    .fontSize(if(breakpoint>=Breakpoint.LG)45.px else 20.px)
                    .fontWeight(FontWeight.Normal)
                    .color(Theme.Primary.rgb)
                    .toAttrs()
            ){
                Text("Welcome to")
            }
            P (
                attrs = Modifier
                    .margin(top = 20.px, bottom = 0.px)
                    .fontFamily(FONT_FAMILY)
                    .fontSize(if(breakpoint>=Breakpoint.LG)68.px else 40.px)
                    .fontWeight(FontWeight.Bolder)
                    .color(Theme.Secondary.rgb)
                    .toAttrs()
            ){
                Text("Renter's eye")
            }
            P (
                attrs = Modifier
                    .margin(top = 10.px, bottom = 5.px)
                    .fontFamily(FONT_FAMILY)
                    .fontSize(20.px)
                    .fontWeight(FontWeight.Bold)
                    .color(Theme.Secondary.rgb)
                    .toAttrs()
            ){
                Text("Protect your property")
            }
            P (
                attrs = Modifier
                    .margin(bottom = 25.px)
                    .maxWidth(400.px)
                    .fontFamily(FONT_FAMILY)
                    .fontSize(15.px)
                    .fontStyle(FontStyle.Italic)
                    .fontWeight(FontWeight.Normal)
                    .color(Theme.Secondary.rgb)
                    .toAttrs()
            ){
                Text("Welcome to our premier real estate inspection services, where your property's safety is our top priority. Our expert team is dedicated to safeguarding your investment by uncovering potential issues that could impact the value and security of your home.")
            }
            Button(
                attrs = MainButtonStyle.toModifier()
                    .height(40.px)
//                    .border(0.px)
                    .borderRadius(r = 5.px)
                    .backgroundColor(Theme.Primary.rgb)
                    .color(Colors.White)
                    .cursor(Cursor.Pointer)
                    .toAttrs()
            ) {
                Link(modifier = Modifier
                    .color(Colors.White)
                    .textDecorationLine(TextDecorationLine.None),
                    text = "Contact us",
                    path = Section.Contact.path
                )

            }
        }
    }
}

@Composable
fun MainImage(){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Bottom
    ) {
        Image(
            modifier = MainImageStyle.toModifier().fillMaxWidth().fillMaxHeight(),
            src = Res.Image.main_image,
            desc = "Main Image"
        )
    }
}