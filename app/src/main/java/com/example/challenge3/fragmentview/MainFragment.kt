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
import com.example.challenge3.adapter.AlphabetAdapter
import com.example.challenge3.databinding.FragmentMainBinding
import com.example.challenge3.view.MainActivity

class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    private val adapter = AlphabetAdapter()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        clearToolbarMenu()
        binding.toolbar.inflateMenu(R.menu.menu_fragment)
        setUpToolbar()
        setRv()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
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
        adapter.updateData(generateAlphabetData())

        adapter.setOnItemClickCallback(object : AlphabetAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Char) {
                navigateToBookList(data)
            }
        })
    }

    private fun navigateToBookList(letter: Char) {
        val bundle = Bundle()
        bundle.putChar(ListFragment.KEY_LETTER, letter)
        view?.findNavController()?.navigate(R.id.action_mainFragment_to_listFragment, bundle)
    }

    private fun generateAlphabetData(): List<Char> {
        return ('A'..'J').toList()
    }
}