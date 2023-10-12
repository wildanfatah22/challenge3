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
import com.example.challenge3.adapter.AlphabetAdapter
import com.example.challenge3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val adapter = AlphabetAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val toolbar = binding.toolbar
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        binding.rvList.setHasFixedSize(true)
        setRv()

    }

    private fun setRv() {
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
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
        val intent = Intent(this@MainActivity, ListActivity::class.java)
        intent.putExtra(ListActivity.KEY_LETTER, letter)
        startActivity(intent)
    }

    private fun generateAlphabetData(): List<Char> {
        return ('A'..'J').toList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_activity, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
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
}