package com.maasbodev.marvelcomicsmd

import androidx.compose.ui.test.hasAnySibling
import androidx.compose.ui.test.hasContentDescription
import androidx.compose.ui.test.hasParent
import androidx.compose.ui.test.hasScrollToIndexAction
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performScrollToIndex
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import arrow.core.Either
import com.maasbodev.marvelcomicsmd.ui.screens.common.MarvelItemsListScreen
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class MarvelItemsListScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    private val ctx = InstrumentationRegistry.getInstrumentation().targetContext

    private val items: List<com.maasbodev.marvelcomicsmd.domain.entities.Comic> = (1..100).map {
        com.maasbodev.marvelcomicsmd.domain.entities.Comic(
            id = it,
            title = "Title $it",
            description = "Description $it",
            thumbnail = "",
            format = com.maasbodev.marvelcomicsmd.domain.entities.Comic.Format.COMIC,
            urls = emptyList(),
            references = emptyList()
        )
    }

    @Before
    fun setUp() {
        composeTestRule.setContent {
            MarvelItemsListScreen(items = Either.Right(items), onClick = {})
        }
    }

    @Test
    fun navigatesTo51(): Unit = with(composeTestRule) {
        onNode(hasScrollToIndexAction()).performScrollToIndex(25)
        onNodeWithText("Title 51").assertExists()
    }

    @Test
    fun navigatesTo51AndShowsBottomSheet(): Unit = with(composeTestRule) {
        onNode(hasScrollToIndexAction()).performScrollToIndex(25)
        onNode(
            hasParent(hasText("Title 51")) and
                hasContentDescription(ctx.getString(R.string.more_options))
        ).performClick()

        onNode(
            hasAnySibling(hasText(ctx.getString(R.string.go_to_detail))) and
                hasText("Title 51")
        ).assertExists()
    }
}
