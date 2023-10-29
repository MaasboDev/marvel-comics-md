package com.maasbodev.marvelcomicsmd

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import com.maasbodev.marvelcomicsmd.ui.navigation.Navigation
import com.maasbodev.marvelcomicsmd.ui.theme.MarvelComicsMDTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MarvelApp {
                Navigation()
            }
        }
    }
}

// Minut 1:17:26
@Composable
fun MarvelApp(content: @Composable () -> Unit) {
    MarvelComicsMDTheme {
        Surface(color = MaterialTheme.colorScheme.background) {
            content()
        }
    }
}
