package com.nadap.models

enum class Section(
    val id: String,
    val title: String,
    val subtitle: String,
    val path: String
) {

    Home(
        id = "home",
        title = "Home",
        subtitle = "",
        path = "#home"
    ),
    About(
        id = "about",
        title = "About Us",
        subtitle = "Why you need this software?",
        path = "#about"
    ),
    Service(
        id = "service",
        title = "Service",
        subtitle = "I am good at",
        path = "#service"
    ),
    Portfolio(
        id = "portfolio",
        title = "Portfolio",
        subtitle = "My work",
        path = "#portfolio"
    ),
    Experience(
        id = "experience",
        title = "Experience",
        subtitle = "Work Experience",
        path = "#experience"
    ),
    Contact(
        id = "contact",
        title = "Contact me",
        subtitle = "Get in Touch",
        path = "#contact"
    ),
    Testimonial(
        id = "testimonial",
        title = "Testimonial",
        subtitle = "Happy Customers",
        path = "#testimonial"
    ),
    Achievements(
        id = "achievements",
        title = "Achievements",
        subtitle = "Personal Achievements",
        path = "#achievements"
    ),
    Test(
        id = "test",
        title = "Test",
        subtitle = "Test",
        path = "#test"
    ),
}