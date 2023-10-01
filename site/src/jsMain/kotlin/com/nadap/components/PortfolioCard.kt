package com.nadap.components

import androidx.compose.runtime.Composable
import com.nadap.models.Portfolio
import com.nadap.models.Theme
import com.nadap.styles.PortfolioSectionStyle
import com.nadap.util.Constants
import com.nadap.util.Constants.FONT_FAMILY
import com.nadap.util.Constants.WEBSITE
import com.nadap.util.Res
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.ObjectFit
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.css.Width
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Color.Companion.argb
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.navigation.OpenLinkStrategy
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.style.toModifier
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun PortfolioCard(
    modifier: Modifier = Modifier,
    portfolio: Portfolio,
    link: String = WEBSITE
){
    Link(
        modifier = PortfolioSectionStyle.toModifier().textDecorationLine(TextDecorationLine.None),
        path = link,
        openExternalLinksStrategy = OpenLinkStrategy.IN_NEW_TAB
    ){
        Column(modifier = modifier
            .id("columnParent")
            .width(Width.MaxContext)) {
            Box(
                modifier = Modifier
                    .id("boxParent")
                    .fillMaxWidth()
                    .maxWidth(300.px)
                    .margin(bottom = 20.px)
            ) {
                Image(
                    modifier = Modifier
                        .size(300.px)
                        .objectFit(ObjectFit.Cover)
                        .borderRadius(
                            topLeft = 24.px,
                            topRight = 24.px,
                            bottomLeft = 24.px,
                            bottomRight = 24.px
                        ),
                    src = portfolio.image,
                    desc = "Portfolio Image"
                )
                Box(
                    modifier = Modifier
                        .id("blueOverlay")
                        .fillMaxHeight()
                        .backgroundColor(argb(a = 0.5f, r = 46, g = 139, b = 192))
                        .borderRadius(
                            topLeft = 24.px,
                            topRight = 24.px,
                            bottomLeft = 24.px,
                            bottomRight = 24.px
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        modifier = Modifier
                            .id("linkIcon")
                            .size(32.px)
                            .borderRadius(
                                topLeft = 24.px,
                                topRight = 24.px,
                                bottomLeft = 24.px,
                                bottomRight = 24.px
                            ),
                        src = Res.Image.link,
                        desc = "Link Icon"
                    )
                }
            }
            P (
                attrs = Modifier
                    .id("portfolioTitle")
                    .fillMaxWidth()
                    .margin(topBottom = 0.px)
                    .fontFamily(FONT_FAMILY)
                    .fontSize(18.px)
                    .fontWeight(FontWeight.Bold)
                    .toAttrs()
            ) {
                Text(portfolio.title)
            }
            P (
                attrs = Modifier
                    .id("portfolioDesc")
                    .fillMaxWidth()
                    .margin(topBottom = 0.px)
                    .fontFamily(FONT_FAMILY)
                    .fontSize(14.px)
                    .fontWeight(FontWeight.Normal)
                    .color(Theme.Secondary.rgb)
                    .opacity(50.percent)
                    .toAttrs()
            ) {
                Text(portfolio.title)
            }
        }
    }
}