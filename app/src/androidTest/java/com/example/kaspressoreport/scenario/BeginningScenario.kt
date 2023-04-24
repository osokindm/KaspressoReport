package com.example.kaspressoreport.scenario

import com.kaspersky.kaspresso.testcases.api.scenario.Scenario
import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import com.example.kaspressoreport.screen.FirstScreen
import com.example.kaspressoreport.screen.SecondScreen

class BeginningScenario : Scenario() {

    override val steps: TestContext<Unit>.() -> Unit = {
        step("Open the First Screen and Check") {
            FirstScreen {
                helloText {
                    isVisible()
                    containsText("Hello first fragment")
                }

                nextButton {
                    isVisible()
                }
            }
        }

        step("Transition to the Second Screen") {
            FirstScreen {
                nextButton {
                    click()
                }
            }
        }

        step("Check the Second Screen") {
            SecondScreen {
                previousButton {
                    isVisible()
                }
            }
        }
    }
}