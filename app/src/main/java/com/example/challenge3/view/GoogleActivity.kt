package com.example.challenge3.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import com.example.challenge3.databinding.ActivityGoogleBinding
import com.example.challenge3.helper.WebViewManager

class GoogleActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGoogleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGoogleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val webView = binding.webView
        val searchQuery = intent.getStringExtra(EXTRA_SEARCH_QUERY)

        if (!searchQuery.isNullOrBlank()) {
            val url = "https://www.google.com/search?q=$searchQuery"
            val webViewManager = WebViewManager(webView, this)
            webViewManager.loadUrl(url)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    companion object {
        const val EXTRA_SEARCH_QUERY = "extra_search_query"
    }
}