package com.example.kaspressoreport.screen

import com.kaspersky.kaspresso.screens.KScreen
import com.example.kaspressoreport.FirstFragment
import com.example.kaspressoreport.R
import io.github.kakaocup.kakao.edit.KEditText
import io.github.kakaocup.kakao.text.KButton

object FirstScreen : KScreen<FirstScreen>() {

    override val layoutId: Int = R.layout.fragment_first
    override val viewClass: Class<*> = FirstFragment::class.java

    val helloText = KEditText { withId(R.id.textview_first) }
    val nextButton = KButton { withId(R.id.button_first) }
}