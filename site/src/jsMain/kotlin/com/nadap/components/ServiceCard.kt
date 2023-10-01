package com.nadap.components

import androidx.compose.runtime.Composable
import com.nadap.models.Service
import com.nadap.models.Theme
import com.nadap.styles.AboutImageStyle
import com.nadap.styles.AboutTextStyle
import com.nadap.styles.ServiceCardStyle
import com.nadap.styles.ServiceImageStyle
import com.nadap.util.Constants
import com.nadap.util.Constants.FONT_FAMILY
import com.varabyte.kobweb.compose.css.FontStyle
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.style.cssRules
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.theme.shapes.clip
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text
import org.w3c.dom.Image

@Composable
fun ServiceCard(service: Service){
        Column(
                modifier = ServiceCardStyle.toModifier()
                        .maxWidth(290.px)
                        .margin(all = 20.px)
                        .padding(all = 20.px)
                        .borderRadius(
                                topLeft = 24.px,
                                topRight = 24.px,
                                bottomLeft = 24.px,
                                bottomRight = 24.px
                        )
        ) {
                Box(
                        modifier = Modifier
                                .id("iconBox")
                                //.padding(all = 10.px)
                                .margin(bottom = 20.px)
//                                .border(width = 2.px,
//                                        style = LineStyle.Solid,
//                                        color = Theme.Primary.rgb)
                                .borderRadius(
                                        topLeft = 24.px,
                                        topRight = 24.px,
                                        bottomLeft = 24.px,
                                        bottomRight = 24.px
                                )
                ) {
                        Image(
                                modifier = ServiceImageStyle.toModifier().fillMaxWidth(100.percent)
                                        .borderRadius(
                                                topLeft = 24.px,
                                                topRight = 24.px,
                                                bottomLeft = 24.px,
                                                bottomRight = 24.px
                                        ),
                                src = service.image,
                                desc = service.description
                        )
                }
                P (
                        attrs = Modifier
                                .fillMaxWidth()
                                .margin(top = 0.px, bottom = 10.px)
                                .fontFamily(FONT_FAMILY)
                                .fontSize(18.px)
                                .fontWeight(FontWeight.Bold)
                                .toAttrs()
                ) {
                        Text(service.title)
                }
                P (
                        attrs = Modifier
                                .fillMaxWidth()
                                .margin(top = 0.px, bottom = 0.px)
                                .fontFamily(FONT_FAMILY)
                                .fontSize(14.px)
                                .fontWeight(FontWeight.Normal)
                                .toAttrs()
                ) {
                        Text(service.description)
                }
        }
}
