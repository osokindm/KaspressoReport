package com.example.kaspressoreport.screen

import com.kaspersky.kaspresso.screens.KScreen
import com.example.kaspressoreport.FlakyFragment
import com.example.kaspressoreport.R
import io.github.kakaocup.kakao.text.KButton

object FlakyScreen : KScreen<FlakyScreen>() {

    override val layoutId: Int = R.layout.fragment_flaky
    override val viewClass: Class<*> = FlakyFragment::class.java

    val counterTextView = KButton { withId(R.id.textview_flaky) }
    val countButton = KButton { withId(R.id.button_count) }
    val previousButton = KButton { withId(R.id.button_prev) }
}