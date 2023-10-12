package com.example.challenge3.fragmentview

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.challenge3.R
import com.example.challenge3.adapter.BookAdapter
import com.example.challenge3.data.BookList
import com.example.challenge3.databinding.FragmentListBinding
import com.example.challenge3.helper.DummyDataHelper.Companion.generateDummyData
import com.example.challenge3.view.ListActivity
import com.example.challenge3.view.MainActivity

class ListFragment : Fragment() {
    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!
    private val adapter = BookAdapter()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        clearToolbarMenu()
        binding.toolbar.inflateMenu(R.menu.menu_fragment)
        setUpToolbar()
        val selectedAlphabet = arguments?.getChar(ListActivity.KEY_LETTER, 'A')
        val filteredBooks = generateDummyData().filter { it.name.firstOrNull() == selectedAlphabet }
        setRv()
        adapter.updateData(filteredBooks)

        binding.toolbar.setNavigationOnClickListener {
            requireActivity().onBackPressed()
        }
    }

    private fun clearToolbarMenu() {
        binding.toolbar.menu.clear()
    }

    private fun setUpToolbar(){
        binding.toolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.action_list -> {
                    binding.rvList.layoutManager = LinearLayoutManager(view?.context)
                    true
                }
                R.id.action_grid -> {
                    binding.rvList.layoutManager = GridLayoutManager(view?.context, 2)
                    true
                }
                R.id.action_activity -> {
                    val intent = Intent(requireContext(), MainActivity::class.java)
                    Toast.makeText(view?.context, "Menuju main activity", Toast.LENGTH_SHORT).show()
                    startActivity(intent)
                    activity?.finish()
                    true
                }
                else -> false
            }
        }
    }

    private fun setRv() {
        val layoutManager = LinearLayoutManager(view?.context, LinearLayoutManager.VERTICAL, false)
        binding.rvList.layoutManager = layoutManager
        binding.rvList.setHasFixedSize(true)
        binding.rvList.adapter = adapter

        adapter.setOnItemClickCallback(object : BookAdapter.OnItemClickCallback {
            override fun onItemClicked(data: BookList) {
                navigateToWebView(data)
            }
        })
    }

    private fun navigateToWebView(data: BookList) {
        val bundle = Bundle()
        bundle.putString(WebViewFragment.EXTRA_SEARCH_QUERY, data.name)
        view?.findNavController()?.navigate(R.id.action_listFragment_to_webViewFragment, bundle)
    }


    companion object {
        const val KEY_LETTER = "extra_name"
    }
}