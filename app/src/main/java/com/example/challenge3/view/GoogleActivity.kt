package com.example.challenge3.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import com.example.challenge3.databinding.ActivityGoogleBinding

class GoogleActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGoogleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGoogleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val webView = binding.webView

        webView.webViewClient = object : WebViewClient() {
            override fun onPageFinished(view: WebView, url: String) {
                view.loadUrl("javascript:alert('Google berhasil dimuat')")
            }
        }

        webView.webChromeClient = object : WebChromeClient() {
            override fun onJsAlert(view: WebView, url: String, message: String, result: android.webkit.JsResult): Boolean {
                Toast.makeText(this@GoogleActivity, message, Toast.LENGTH_LONG).show()
                result.confirm()
                return true
            }
        }

        val searchQuery = intent.getStringExtra(EXTRA_SEARCH_QUERY)

        if (!searchQuery.isNullOrBlank()) {
            val url = "https://www.google.com/search?q=$searchQuery"
            webView.webViewClient = WebViewClient()
            webView.loadUrl(url)
        }
    }

    companion object {
        const val EXTRA_SEARCH_QUERY = "extra_search_query"
    }
}