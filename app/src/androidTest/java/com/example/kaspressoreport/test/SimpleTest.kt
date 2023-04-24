package com.example.kaspressoreport.test

import android.Manifest
import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.rule.GrantPermissionRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import com.example.kaspressoreport.MainActivity
import com.example.kaspressoreport.scenario.BeginningScenario
import com.example.kaspressoreport.screen.FirstScreen
import com.example.kaspressoreport.screen.SecondScreen
import org.junit.Rule
import org.junit.Test

class SimpleTest : TestCase() {

    @get:Rule
    val runtimePermissionRule: GrantPermissionRule = GrantPermissionRule.grant(
        Manifest.permission.WRITE_EXTERNAL_STORAGE,
        Manifest.permission.READ_EXTERNAL_STORAGE
    )

    @get:Rule
    val activityRule = activityScenarioRule<MainActivity>()

    @Test
    fun test() = run {
        step("Beginning Scenario") {
            scenario(BeginningScenario())
        }

        step("Come back to the First Screen") {
            SecondScreen {
                previousButton {
                    click()
                }
            }

            FirstScreen {
                helloText {
                    isVisible()
                }
            }
        }
    }
}
