package com.example.excercise6oct2023.screens


import android.content.Context
import android.webkit.WebView
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import com.example.excercise6oct2023.ui.theme.Excercise6Oct2023Theme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PageScreen(context: Context) {
    Column {
        AndroidView(
            modifier = Modifier.fillMaxSize().weight(1f),
            factory = {
                val webView = WebView(context)
                val webSettings = webView.settings
                // Enable JavaScript if needed
                webSettings.javaScriptEnabled = true
                // Load a website URL
                webView.loadUrl("https://www.presidio.com")
                webView
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PageScreenPreview() {
    Excercise6Oct2023Theme {
        PageScreen(LocalContext.current)
    }
}