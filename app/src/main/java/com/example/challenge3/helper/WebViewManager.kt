package com.example.challenge3.helper

import android.content.Context
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast

class WebViewManager(private val webView: WebView, private val context: Context) {
    init {
        webView.webViewClient = createWebViewClient()
        webView.webChromeClient = createWebChromeClient()
    }

    private fun createWebViewClient(): WebViewClient {
        return object : WebViewClient() {
            override fun onPageFinished(view: WebView, url: String) {
                view.loadUrl("javascript:alert('Google berhasil dimuat')")
            }
        }
    }

    private fun createWebChromeClient(): WebChromeClient {
        return object : WebChromeClient() {
            override fun onJsAlert(view: WebView, url: String, message: String, result: android.webkit.JsResult): Boolean {
                Toast.makeText(context, message, Toast.LENGTH_LONG).show()
                result.confirm()
                return true
            }
        }
    }

    fun loadUrl(url: String) {
        webView.loadUrl(url)
    }
}