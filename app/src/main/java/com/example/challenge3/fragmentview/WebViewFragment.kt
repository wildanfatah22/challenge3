package com.example.challenge3.fragmentview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.challenge3.databinding.FragmentWebViewBinding
import com.example.challenge3.helper.WebViewManager
import com.example.challenge3.view.GoogleActivity

class WebViewFragment : Fragment() {
    private var _binding: FragmentWebViewBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentWebViewBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val webView = binding.webView
        val searchQuery = arguments?.getString(GoogleActivity.EXTRA_SEARCH_QUERY)

        if (!searchQuery.isNullOrBlank()) {
            val url = "https://www.google.com/search?q=$searchQuery"
            val webViewManager = WebViewManager(webView, view.context)
            webViewManager.loadUrl(url)
        }

        binding.toolbar.setNavigationOnClickListener {
            requireActivity().onBackPressed()
        }
    }

    companion object {
        const val EXTRA_SEARCH_QUERY = "extra_search_query"
    }
}