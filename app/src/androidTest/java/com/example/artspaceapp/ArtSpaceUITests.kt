package com.example.artspaceapp

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.example.artspaceapp.ui.theme.ArtSpaceAppTheme
import org.junit.Rule
import org.junit.Test

class ArtSpaceUITests {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun clickNext_showsSecondArtwork() {
        composeTestRule.setContent {
            ArtSpaceAppTheme {
                ArtSpaceApp()
            }
        }
        composeTestRule.onNodeWithText("Next").performClick()
        composeTestRule.onNodeWithText("Artwork Title 2").assertIsDisplayed()
    }
}