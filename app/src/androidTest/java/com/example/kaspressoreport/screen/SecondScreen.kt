package com.example.kaspressoreport.screen

import com.kaspersky.kaspresso.screens.KScreen
import com.example.kaspressoreport.R
import com.example.kaspressoreport.SecondFragment
import io.github.kakaocup.kakao.text.KButton

object SecondScreen : KScreen<SecondScreen>() {

    override val layoutId: Int = R.layout.fragment_second
    override val viewClass: Class<*> = SecondFragment::class.java

    val openFlakyScreenButton = KButton { withId(R.id.open_flaky_button) }
    val previousButton = KButton { withId(R.id.button_second) }
}