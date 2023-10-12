package com.example.challenge3.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.challenge3.R
import com.example.challenge3.adapter.BookAdapter
import com.example.challenge3.data.BookList
import com.example.challenge3.databinding.ActivityListBinding
import com.example.challenge3.helper.DummyDataHelper.Companion.generateDummyData

class ListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListBinding
    private val adapter = BookAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val selectedAlphabet = intent.getCharExtra(KEY_LETTER, 'A')
        val filteredBooks = generateDummyData().filter { it.name.firstOrNull() == selectedAlphabet }
        setRv()
        adapter.updateData(filteredBooks)
    }

    private fun setRv() {
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rvList.layoutManager = layoutManager
        binding.rvList.setHasFixedSize(true)
        binding.rvList.adapter = adapter

        adapter.setOnItemClickCallback(object : BookAdapter.OnItemClickCallback {
            override fun onItemClicked(data: BookList) {
                navigateToGoogle(data)
            }
        })
    }

    private fun navigateToGoogle(data: BookList) {
        val intent = Intent(this@ListActivity, GoogleActivity::class.java)
        intent.putExtra(GoogleActivity.EXTRA_SEARCH_QUERY, data.name)
        startActivity(intent)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_activity, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }

            R.id.action_list -> {
                binding.rvList.layoutManager = LinearLayoutManager(this)
            }

            R.id.action_grid -> {
                binding.rvList.layoutManager = GridLayoutManager(this, 2)
            }

            R.id.action_fragment -> {
                val intent = Intent(this, FragmentActivity::class.java)
                Toast.makeText(this, "Menuju main fragment", Toast.LENGTH_SHORT).show()
                startActivity(intent)
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }



    companion object {
        const val KEY_LETTER = "extra_name"
    }
}