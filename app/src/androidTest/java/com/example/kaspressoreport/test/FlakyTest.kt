package com.example.kaspressoreport.test

import android.Manifest
import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.rule.GrantPermissionRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import com.example.kaspressoreport.MainActivity
import com.example.kaspressoreport.scenario.BeginningScenario
import com.example.kaspressoreport.screen.FlakyScreen
import com.example.kaspressoreport.screen.SecondScreen
import org.junit.Rule
import org.junit.Test

class FlakyTest : TestCase() {

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

        step("Transition to the Flaky Screen") {
            SecondScreen {
                openFlakyScreenButton {
                    isVisible()
                    click()
                }
            }
        }

        step("Check the Flaky Screen") {
            FlakyScreen {
                counterTextView {
                    isVisible()
                    hasText("Counter: 0")
                }
            }
        }

        step("Count and check") {
            FlakyScreen {
                countButton {
                    click()
                }

                counterTextView {
                    flakySafely(timeoutMs = 15000) {
                        hasText("Counter: 1")
                    }
                }

                countButton {
                    click()
                }

                counterTextView {
                    hasText("Counter: 2")
                }
            }
        }
    }
}
